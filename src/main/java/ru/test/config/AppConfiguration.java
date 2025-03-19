package ru.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.test.Service1;
import ru.test.Worker3;
import ru.test.Worker4;
import ru.test.mapper.TestMapper;
import ru.test.mapper.TestMapperImpl;

@Configuration
public class AppConfiguration {

    @Value("${version}")
    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

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
