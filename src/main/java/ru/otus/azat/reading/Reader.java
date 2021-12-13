package ru.otus.azat.reading;

import ru.otus.azat.entities.Question;

import java.util.List;

public interface Reader {
    List<Question> readAll();
}
