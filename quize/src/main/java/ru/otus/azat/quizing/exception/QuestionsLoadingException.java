package ru.otus.azat.quizing.exception;

public class QuestionsLoadingException extends RuntimeException {
    public QuestionsLoadingException(String message, Throwable cause) {
        super(message, cause);
    }
}
