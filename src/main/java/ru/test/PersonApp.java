package ru.test;

import ru.test.config.AppConfiguration;
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


        var wrongDto = new PersonAndDogSaveInformationDto("Иван", 25, List.of(
                new DogDto("Бобик"), new DogDto("Шарик")
        ));
        var result = personAndDogService.saveInformationAboutPersonAndDogs(wrongDto);

        var worker2 = new Worker2(personAndDogService, worker3);
        System.out.println(result.getMessage());
        System.out.println(worker2);
    }


}
