package ru.otus.azat.library.exceptions;

public class AuthorException extends RuntimeException{
    public AuthorException (String message, Throwable cause) {super(message, cause);}

    public AuthorException() {

    }
}
