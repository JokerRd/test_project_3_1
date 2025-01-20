package ru.test;

import ru.test.dto.DogDto;
import ru.test.dto.PersonAndDogSaveInformationDto;
import ru.test.service.PersonAndDogService;

import java.util.List;

public class Worker {

    private final PersonAndDogService personAndDogService;

    public Worker(PersonAndDogService personAndDogService) {
        this.personAndDogService = personAndDogService;
    }

    public void doIt() {
        var wrongDto = new PersonAndDogSaveInformationDto("Федор", 25, List.of(
                new DogDto("Бобик"), new DogDto("Шарик")
        ));
        var result = personAndDogService.saveInformationAboutPersonAndDogs(wrongDto);
        System.out.println(result.getMessage());
    }

}
