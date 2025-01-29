package ru.test;

import ru.test.dto.DogDto;
import ru.test.dto.PersonAndDogSaveInformationDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.test.service.PersonAndDogService;
import ru.test.service.PersonAndDogServiceImpl;

import java.util.List;

@SpringBootApplication
public class PersonApp {

    public static void main(String[] args) {
        var context = SpringApplication.run(PersonApp.class, args);
        var personAndDogService = context.getBean(PersonAndDogService.class);


        var worker3 = context.getBean(Worker3.class);
        var worker3_1 = context.getBean(Worker3.class);
        System.out.println(worker3.equals(worker3_1));

        var service1 = context.getBean(Service1.class);
        var service2 = context.getBean(Service2.class);

        service1.doIt();
        service2.doIt();

        var wrongDto = new PersonAndDogSaveInformationDto("Иван", 25, List.of(
                new DogDto("Бобик"), new DogDto("Шарик")
        ));
        var result = personAndDogService.saveInformationAboutPersonAndDogs(wrongDto);

        System.out.println(result.getMessage());
    }


}
