package repository;

import model.Dog;

public interface DogRepository {

    Dog get(Long id);
    Long create(Dog dog);
}
