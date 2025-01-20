package ru.test;

import ru.test.repository.DogRepository;
import ru.test.repository.DogRepositorySimple;
import ru.test.repository.PersonRepository;
import ru.test.repository.PersonRepositorySimple;
import ru.test.service.PersonAndDogService;
import ru.test.service.PersonAndDogServiceImpl;
import ru.test.service.PersonVerificationService;

public class DependencyManager {

    public <T> T getDependency(Class<T> clazz) {
        if (clazz.getName().equals(PersonAndDogService.class.getName())) {
            PersonRepository personRepository = new PersonRepositorySimple();
            DogRepository dogRepository = new DogRepositorySimple();
            var personVerificationService = new PersonVerificationService();
            return (T) new PersonAndDogServiceImpl(personVerificationService, dogRepository, personRepository);
        } else if (clazz.getName().equals(Worker3.class.getName())) {
            var worker4 = new Worker4();
            return (T) new Worker3(worker4);
        } else {
            throw new IllegalArgumentException("Нет такого класа");
        }
    }

}
