package ru.test;

import ru.test.config.AppConfiguration;
import ru.test.dto.DogDto;
import ru.test.dto.PersonAndDogSaveInformationDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.test.dto.TestMapperDto;
import ru.test.mapper.TestMapper;
import ru.test.mapper.TestMapperImpl;
import ru.test.model.Dog;
import ru.test.model.TestMapperEntity;
import ru.test.service.PersonAndDogService;
import ru.test.service.PersonAndDogServiceImpl;

import java.util.List;

@SpringBootApplication
public class PersonApp {

    public static void main(String[] args) {
        var context = SpringApplication.run(PersonApp.class, args);
        var config = context.getBean(AppConfiguration.class);
        var testMapperDto = new TestMapperDto(
                1, "name", 2, "43", "dfsfsd", "dfsfd",
                "dsfsdf", "sdfsdfd",
                "2433242","dsdfds", "sdfsf", "dsfd", "dfsf"
        );

        TestMapper testMapper = new TestMapperImpl();
        var testMapperEntity = testMapper.fromDto(testMapperDto, 1);
        testMapper.fromDto2("testMapperDto", testMapperEntity);
        System.out.println(testMapperEntity);
//        var personAndDogService = context.getBean(PersonAndDogService.class);
//
//
//        var worker3 = context.getBean(Worker3.class);
//        var worker3_1 = context.getBean(Worker3.class);
//        System.out.println(worker3.equals(worker3_1));
//
//        var service1 = context.getBean(Service1.class);
//        var service2 = context.getBean(Service2.class);
//
//        service1.doIt();
//        service2.doIt();
//
//        var wrongDto = new PersonAndDogSaveInformationDto("Иван", 25, List.of(
//                new DogDto("Бобик"), new DogDto("Шарик")
//        ));
//        var result = personAndDogService.saveInformationAboutPersonAndDogs(wrongDto);
//
//        System.out.println(result.getMessage());
    }


}
