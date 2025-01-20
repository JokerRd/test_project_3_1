package ru.test.service;

import org.springframework.stereotype.Component;
import java.util.List;

@Component
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
