package ru.test.model;

import lombok.*;
import ru.test.exception.ValidateException;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Person {

    private long id;
    private String name;
    private int age;
    private long countProblem;
    private List<Long> idDogs;

    public Person(long id, String name, int age, long countProblem, List<Long> idDogs) {
        if (age < 0) {
            throw new ValidateException();
        }
        this.id = id;
        this.name = name;
        this.age = age;
        this.countProblem = countProblem;
        this.idDogs = idDogs;
    }

    public Person(String name, int age, List<Long> idDogs) {
        this.name = name;
        this.age = age;
        this.idDogs = idDogs;
    }

}
