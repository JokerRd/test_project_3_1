import dto.DogDto;
import dto.PersonAndDogSaveInformationDto;
import exception.ValidateException;
import model.Person;
import repository.DogRepository;
import repository.DogRepositorySimple;
import repository.PersonRepository;
import repository.PersonRepositorySimple;
import service.PersonAndDogService;
import service.PersonAndDogServiceImpl;
import service.PersonVerificationService;

import java.util.List;

public class PersonApp {


    public static void main(String[] args) {
        PersonRepository personRepository = new PersonRepositorySimple();
        DogRepository dogRepository = new DogRepositorySimple();
        var personVerificationService = new PersonVerificationService();
        PersonAndDogService personAndDogService = new PersonAndDogServiceImpl(personVerificationService,
                dogRepository, personRepository);

        var wrongDto = new PersonAndDogSaveInformationDto("Иван", 25, List.of(
                new DogDto("Бобик"), new DogDto("Шарик")
        ));
        var result = personAndDogService.saveInformationAboutPersonAndDogs(wrongDto);
        System.out.println(result.getMessage());
    }


}
