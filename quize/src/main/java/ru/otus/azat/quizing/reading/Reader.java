package ru.otus.azat.quizing.reading;

import ru.otus.azat.quizing.entities.Question;

import java.util.List;

public interface Reader {
    List<Question> readAll();
}
