package ru.otus.azat.library.entity;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Author {
    long id;
    String fullName;
}
