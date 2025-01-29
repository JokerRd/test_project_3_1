package ru.test.service;

import org.springframework.stereotype.Service;
import ru.test.dto.PersonAndDogSaveInformationDto;
import ru.test.dto.PersonInformationDto;
import ru.test.dto.ResultSaveInformationDto;
import ru.test.dto.UpdatePersonInformation;

@Service
public class PersonAndDogServiceEmpty implements PersonAndDogService {

    @Override
    public ResultSaveInformationDto saveInformationAboutPersonAndDogs(PersonAndDogSaveInformationDto dto) {
        return null;
    }

    @Override
    public PersonInformationDto getPersonById(long id) {
        return null;
    }

    @Override
    public ResultSaveInformationDto updatePersonInformation(UpdatePersonInformation dto) {
        return null;
    }

    @Override
    public boolean deletePersonById(long id) {
        return false;
    }

}
