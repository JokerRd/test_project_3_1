package repository;

import model.Dog;
import java.util.HashMap;
import java.util.Map;

public class DogRepositorySimple implements DogRepository{

    private Map<Long, Dog> dogs = new HashMap<>();
    private int counterId = 0;

    @Override
    public Dog get(Long id) {
        return dogs.get(id);
    }

    @Override
    public Long create(Dog dog) {
        counterId++;
        dog.setId(counterId);
        dogs.put(dog.getId(), dog);
        return dog.getId();
    }
}
