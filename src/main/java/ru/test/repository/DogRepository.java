package ru.test.repository;

import ru.test.model.Dog;

public interface DogRepository {

    Dog get(Long id);
    Long create(Dog dog);
}
