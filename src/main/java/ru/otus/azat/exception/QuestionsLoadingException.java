package ru.otus.azat.exception;

public class QuestionsLoadingException extends RuntimeException {
    public QuestionsLoadingException(String message, Throwable cause) {
        super(message, cause);
    }
}
