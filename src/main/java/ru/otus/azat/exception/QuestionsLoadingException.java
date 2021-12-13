package ru.otus.azat.exception;

import java.io.IOException;

public class QuestionsLoadingException extends IOException {
    public QuestionsLoadingException(String message) {
        super(message);
    }
}
