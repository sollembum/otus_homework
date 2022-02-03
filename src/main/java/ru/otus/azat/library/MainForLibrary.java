package ru.otus.azat.library;

import org.h2.tools.Console;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class MainForLibrary {
    public static void main(String[] args) throws SQLException {
        Console.main(args);
    }
}
