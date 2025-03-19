package ru.test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.test.dto.*;
import ru.test.mapper.TestMapper;
import ru.test.model.Dog;
import ru.test.model.Person;
import ru.test.repository.DogRepository;
import ru.test.repository.PersonRepository;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
@RequiredArgsConstructor
public class PersonAndDogServiceImpl implements PersonAndDogService {

    private final PersonVerificationService personVerificationService;

    @Qualifier(value = "dogRepositorySimple") private final DogRepository dogRepository;

    private final PersonRepository personRepository;

    private final TestMapper testMapper;

    @Override
    public ResultSaveInformationDto saveInformationAboutPersonAndDogs(PersonAndDogSaveInformationDto dto) {
        var errorMessage = validate(dto);
        if (errorMessage != null) {
            return new ResultSaveInformationDto(null, false, errorMessage);
        }
        if (!personVerificationService.isTrustedPerson(dto.getName())) {
            var message = String.format("Челевек с именем %s не существует", dto.getName());
            return new ResultSaveInformationDto(null, false, message);
        }
        List<Long> dogsIds = dto.getDogs() == null ? Collections.emptyList()
                : dto.getDogs().stream().map(this::createDog).collect(Collectors.toList());

//        if (ru.test.dto.getDogs() != null && !ru.test.dto.getDogs().isEmpty()) {
//            for (DogDto dtoDog : ru.test.dto.getDogs()) {
//                var newDog = new Dog(dtoDog.getName());
//                var idDog = dogRepository.create(newDog);
//                dogsIds.add(idDog);
//            }
//        }

        var person = testMapper.fromDto(dto, dogsIds);
        var idPerson = personRepository.create(person);

        return new ResultSaveInformationDto(idPerson, true, "Все ок");
    }

    @Override
    public PersonInformationDto getPersonById(long id) {
        var person = personRepository.get(id);
        if (person == null) {
            return null;
        }
        var dogs = person.getIdDogs().stream()
                .map(dogRepository::get)
                .map(dog -> new DogDto(dog.getName()))
                .collect(Collectors.toList());
        return testMapper.fromPerson(person, dogs);
    }

    @Override
    public ResultSaveInformationDto updatePersonInformation(UpdatePersonInformation dto) {
        var person = personRepository.get(dto.getId());
        person.setName(dto.getName());
        personRepository.update(person);
        return new ResultSaveInformationDto(person.getId(), true, "Ок");
    }

    @Override
    public boolean deletePersonById(long id) {
        return personRepository.delete(id);
    }

    private Long createDog(DogDto dogDto) {
        var newDog = new Dog(dogDto.getName());
        return dogRepository.create(newDog);
    }


    private String validate(PersonAndDogSaveInformationDto dto) {
        if (dto.getName() == null || dto.getName().isEmpty()) {
            return "Имя человека не может быть пустым";
        }
        if (dto.getAge() < 0 || dto.getAge() > 150) {
            return "Возраст человека не может быть меньше 0 или больше 150 лет";
        }

        if (dto.getDogs() != null && isAnyDogWithEmptyName(dto.getDogs())) {
            return "Не может быть собаки с пустым именем";
        }
        return null;
    }

    private boolean isAnyDogWithEmptyName(List<DogDto> dogs) {
        return dogs.stream()
                .anyMatch(this::isEmptyDogName);
    }

    private boolean isEmptyDogName(DogDto dog) {
        return dog.getName() == null || dog.getName().isEmpty();
    }

}
