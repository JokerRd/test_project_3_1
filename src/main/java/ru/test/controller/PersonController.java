package ru.test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.test.dto.PersonAndDogSaveInformationDto;
import ru.test.dto.PersonInformationDto;
import ru.test.dto.ResultSaveInformationDto;
import ru.test.dto.UpdatePersonInformation;
import ru.test.service.PersonAndDogService;

@RestController
public class PersonController {

    private final PersonAndDogService personAndDogService;

    public PersonController(PersonAndDogService personAndDogService) {
        this.personAndDogService = personAndDogService;
    }

    @PostMapping("/person_with_dogs")
    public ResultSaveInformationDto registerPerson(@RequestBody PersonAndDogSaveInformationDto personAndDogSaveInformationDto) {
        return personAndDogService.saveInformationAboutPersonAndDogs(personAndDogSaveInformationDto);
    }

    @GetMapping("/person_with_dogs/{id}")
    public ResponseEntity<PersonInformationDto> getPersonById(@PathVariable long id) {
        var result = personAndDogService.getPersonById(id);
        return result != null ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
    }

    @PutMapping("/person_with_dogs")
    public ResultSaveInformationDto updatePerson(@RequestBody UpdatePersonInformation personInformationDto) {
        return personAndDogService.updatePersonInformation(personInformationDto);
    }

    @DeleteMapping("/person_with_dogs/{id}")
    public ResponseEntity<?> deleteByPersonId(@PathVariable long id) {
        var isDelete = personAndDogService.deletePersonById(id);
        return isDelete ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }


}
