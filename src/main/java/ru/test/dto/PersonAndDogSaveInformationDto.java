package ru.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PersonAndDogSaveInformationDto {

    @NotNull(message = "Поле name не может быть null")
    @NotEmpty(message = "Поле name не может быть пустым")
    private String name;

    @Min(value = 0)
    @Max(value = 100)
    private int age;

    @Size(min = 1)
    private List<DogDto> dogs;


}
