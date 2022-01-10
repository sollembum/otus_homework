package ru.otus.azat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import ru.otus.azat.service.QuizeService;

import java.util.Locale;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        ApplicationContext context =
                SpringApplication.run(Main.class, args);
        QuizeService service = context.getBean(QuizeService.class);
        service.startQuize();

    }
}
