package ru.test.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dog {

    private long id;
    private String name;

    public Dog(String name) {
        this.name = name;
    }
}
