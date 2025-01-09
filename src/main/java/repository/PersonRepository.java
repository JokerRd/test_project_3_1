package repository;

import model.Person;

public interface PersonRepository {

    Person get(Long id);

    Long create(Person person);
}
