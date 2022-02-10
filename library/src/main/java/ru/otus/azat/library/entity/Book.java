package ru.otus.azat.library.entity;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Book {
    long id;
    String title;
    Author author;
    Genre genre;
}
