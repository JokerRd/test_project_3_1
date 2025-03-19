package ru.test.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.test.dto.DogDto;
import ru.test.dto.PersonAndDogSaveInformationDto;
import ru.test.dto.PersonInformationDto;
import ru.test.dto.TestMapperDto;
import ru.test.model.Dog;
import ru.test.model.Person;
import ru.test.model.TestMapperEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TestMapper {

    @Mapping(target = "mail", source = "dto.email")
    @Mapping(target = "text", source = "dto.description")
    @Mapping(target = "ignore", ignore = true)
    @Mapping(target = "constant", constant = "Hello")
    TestMapperEntity fromDto(TestMapperDto dto, Integer test);

    void fromDto2(String ignore, @MappingTarget TestMapperEntity entity);

    @Mapping(target = "dogDtoList", source = "dogs")
    PersonInformationDto fromPerson(Person person, List<DogDto> dogs);

    @Mapping(target = "idDogs", source = "dogsIds")
    Person fromDto(PersonAndDogSaveInformationDto dto, List<Long> dogsIds);
}
