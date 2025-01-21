package ru.test.repository;

import org.springframework.stereotype.Repository;
import ru.test.model.Dog;

@Repository
public class DogRepositoryEmpty implements DogRepository {

    @Override
    public Dog get(Long id) {
        return null;
    }

    @Override
    public Long create(Dog dog) {
        return 0L;
    }
}
