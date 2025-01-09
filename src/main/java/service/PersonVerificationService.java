package service;

import java.util.List;

public class PersonVerificationService {

    private final List<String> trustedPersonNames = List.of(
            "Иван",
            "Денис",
            "Влад"
    );


    public boolean isTrustedPerson(String personName) {
        return trustedPersonNames.contains(personName);
    }


}
