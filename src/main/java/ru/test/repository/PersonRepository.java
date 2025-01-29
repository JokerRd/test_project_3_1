package ru.test.repository;

import ru.test.model.Person;

public interface PersonRepository {

    Person get(Long id);

    Long create(Person person);

    void update(Person person);

    boolean delete(Long id);
}
