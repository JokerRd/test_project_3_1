package ru.test.service;

import ru.test.dto.PersonAndDogSaveInformationDto;
import ru.test.dto.ResultSaveInformationDto;

public interface PersonAndDogService {

    ResultSaveInformationDto saveInformationAboutPersonAndDogs(PersonAndDogSaveInformationDto dto);

}
