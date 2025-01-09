package repository;

import model.Person;

import java.util.HashMap;
import java.util.Map;

public class PersonRepositorySimple implements PersonRepository {

    private Map<Long, Person> persons = new HashMap<>();
    private int counterId = 0;

    @Override
    public Person get(Long id) {
        return persons.get(id);
    }

    @Override
    public Long create(Person person) {
        counterId++;
        person.setId(counterId);
        persons.put(person.getId(), person);
        return person.getId();
    }

}
