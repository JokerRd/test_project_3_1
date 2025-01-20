package ru.test;

import ru.test.dto.DogDto;
import ru.test.dto.PersonAndDogSaveInformationDto;
import ru.test.service.PersonAndDogService;

import java.util.List;

public class Worker2 {

    private final PersonAndDogService personAndDogService;
    private final Worker3 worker3;

    public Worker2(PersonAndDogService personAndDogService, Worker3 worker3) {
        this.personAndDogService = personAndDogService;
        this.worker3 = worker3;
    }

    public void doIt() {
        var wrongDto = new PersonAndDogSaveInformationDto("Ирина", 25, List.of(
                new DogDto("Бобик"), new DogDto("Шарик")
        ));
        var result = personAndDogService.saveInformationAboutPersonAndDogs(wrongDto);
        worker3.work();
        System.out.println(result.getMessage());
    }

}
