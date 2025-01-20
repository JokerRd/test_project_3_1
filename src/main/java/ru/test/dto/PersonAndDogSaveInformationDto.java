package ru.test.dto;

import java.util.List;

public class PersonAndDogSaveInformationDto {

    private String name;
    private int age;
    List<DogDto> dogs;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<DogDto> getDogs() {
        return dogs;
    }


    public PersonAndDogSaveInformationDto(String name, int age, List<DogDto> dogs) {
        this.name = name;
        this.age = age;
        this.dogs = dogs;
    }
}
