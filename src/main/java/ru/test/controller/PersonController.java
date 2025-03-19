package ru.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import ru.test.dto.*;
import ru.test.service.PersonAndDogService;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.stream.Collectors;

@Validated
@RestController
public class PersonController {

    private final PersonAndDogService personAndDogService;

    public PersonController(PersonAndDogService personAndDogService) {
        this.personAndDogService = personAndDogService;
    }

    @PostMapping("/person_with_dogs")
    public ResultSaveInformationDto registerPerson(@RequestBody @Valid PersonAndDogSaveInformationDto personAndDogSaveInformationDto) {
        return personAndDogService.saveInformationAboutPersonAndDogs(personAndDogSaveInformationDto);
    }

    @GetMapping("/person_with_dogs/{id}")
    public ResponseEntity<PersonInformationDto> getPersonById(@PathVariable @Min(1) long id) {
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

    @ExceptionHandler({ MethodArgumentNotValidException.class })
    public ResponseEntity<?> handleException(MethodArgumentNotValidException e) {
        var bind = e.getBindingResult();
        var message = bind.getFieldErrors().stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .collect(Collectors.joining("; "));
        return ResponseEntity.badRequest().body(new ErrorDto(message));
    }


}
