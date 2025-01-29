package ru.test.service;

import ru.test.dto.PersonAndDogSaveInformationDto;
import ru.test.dto.PersonInformationDto;
import ru.test.dto.ResultSaveInformationDto;
import ru.test.dto.UpdatePersonInformation;

public interface PersonAndDogService {

    ResultSaveInformationDto saveInformationAboutPersonAndDogs(PersonAndDogSaveInformationDto dto);

    PersonInformationDto getPersonById(long id);

    ResultSaveInformationDto updatePersonInformation(UpdatePersonInformation dto);

    boolean deletePersonById(long id);

}
