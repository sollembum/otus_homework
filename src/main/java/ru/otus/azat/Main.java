package ru.otus.azat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import ru.otus.azat.service.QuizeService;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                SpringApplication.run(Main.class, args);
    }
}
