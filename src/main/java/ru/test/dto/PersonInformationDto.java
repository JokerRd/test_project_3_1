package ru.test.dto;

import java.util.List;

public class PersonInformationDto {

    private long id;
    private String name;
    private int age;
    private long countProblem;
    private List<DogDto> dogDtoList;

    public PersonInformationDto() {

    }

    public PersonInformationDto(long id, String name, int age, long countProblem, List<DogDto> dogDtoList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.countProblem = countProblem;
        this.dogDtoList = dogDtoList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getCountProblem() {
        return countProblem;
    }

    public void setCountProblem(long countProblem) {
        this.countProblem = countProblem;
    }

    public List<DogDto> getDogDtoList() {
        return dogDtoList;
    }

    public void setDogDtoList(List<DogDto> dogDtoList) {
        this.dogDtoList = dogDtoList;
    }
}
