package ru.otus.azat;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import ru.otus.azat.service.QuizeServiceImpl;

@ComponentScan
@PropertySource("classpath:application.properties")
public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);
        QuizeServiceImpl service = context.getBean(QuizeServiceImpl.class);
        service.startQuize();
    }
}
