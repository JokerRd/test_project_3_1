package ru.test.model;

import ru.test.exception.ValidateException;

import java.util.List;

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

    public List<Long> getIdDogs() {
        return idDogs;
    }

    public void setIdDogs(List<Long> idDogs) {
        this.idDogs = idDogs;
    }

    @Override
    public String toString() {
        return String.format("Человек по имени %s", this.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }
}
