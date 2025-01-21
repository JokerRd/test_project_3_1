package ru.test.service;

import org.springframework.stereotype.Service;
import ru.test.dto.PersonAndDogSaveInformationDto;
import ru.test.dto.ResultSaveInformationDto;

@Service
public class PersonAndDogServiceEmpty implements PersonAndDogService {

    @Override
    public ResultSaveInformationDto saveInformationAboutPersonAndDogs(PersonAndDogSaveInformationDto dto) {
        return null;
    }

}
