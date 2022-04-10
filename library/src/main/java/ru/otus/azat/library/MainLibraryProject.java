package ru.otus.azat.library;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@EnableMongock
@EnableMongoRepositories
@SpringBootApplication
public class MainLibraryProject {
    public static void main(String[] args) {
        SpringApplication.run(MainLibraryProject.class, args);
    }
}
