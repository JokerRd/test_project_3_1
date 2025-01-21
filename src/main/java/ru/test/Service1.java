package ru.test;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

@Service
@DependsOn(value = "service2")
public class Service1 {

    private final Counter counter;

    public Service1(Counter counter) {
        this.counter = counter;
    }


    public void doIt() {
        counter.increment();
        System.out.println("1 сервис");
        System.out.printf("Вызван %s раз%n", counter.getCount());
    }

}
