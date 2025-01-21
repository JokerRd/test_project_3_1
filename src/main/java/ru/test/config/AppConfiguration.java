package ru.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.test.Service1;
import ru.test.Worker3;
import ru.test.Worker4;

@Configuration
public class AppConfiguration {

    @Bean
    public Worker4 getWorker4() {
        System.out.println("Первый");
        return new Worker4();
    }

    @Bean
    public Worker3 getWorker3(Worker4 worker4) {
        System.out.println("Создается объект");
        return new Worker3(worker4);
    }
}
