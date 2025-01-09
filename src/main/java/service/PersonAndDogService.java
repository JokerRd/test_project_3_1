package service;

import dto.PersonAndDogSaveInformationDto;
import dto.ResultSaveInformationDto;

public interface PersonAndDogService {

    ResultSaveInformationDto saveInformationAboutPersonAndDogs(PersonAndDogSaveInformationDto dto);

}
