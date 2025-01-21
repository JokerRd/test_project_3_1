package ru.test;

import org.springframework.stereotype.Service;

@Service
public class Service2 {

    private final Counter counter;

    public Service2(Counter counter) {
        this.counter = counter;
    }


    public void doIt() {
        counter.increment();
        System.out.println("2 сервис");
        System.out.printf("Вызван %s раз%n", counter.getCount());
    }

}
