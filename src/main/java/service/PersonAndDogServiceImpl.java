package service;

import dto.DogDto;
import dto.PersonAndDogSaveInformationDto;
import dto.ResultSaveInformationDto;
import model.Dog;
import model.Person;
import repository.DogRepository;
import repository.PersonRepository;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PersonAndDogServiceImpl implements PersonAndDogService {

    private final PersonVerificationService personVerificationService;
    private final DogRepository dogRepository;
    private final PersonRepository personRepository;

    public PersonAndDogServiceImpl(PersonVerificationService personVerificationService,
                                   DogRepository dogRepository,
                                   PersonRepository personRepository) {
        this.personVerificationService = personVerificationService;
        this.dogRepository = dogRepository;
        this.personRepository = personRepository;
    }


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

//        if (dto.getDogs() != null && !dto.getDogs().isEmpty()) {
//            for (DogDto dtoDog : dto.getDogs()) {
//                var newDog = new Dog(dtoDog.getName());
//                var idDog = dogRepository.create(newDog);
//                dogsIds.add(idDog);
//            }
//        }

        var person = new Person(dto.getName(), dto.getAge(), dogsIds);
        var idPerson = personRepository.create(person);

        return new ResultSaveInformationDto(idPerson, true, "Все ок");
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
