package ru.otus.azat.library.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
    Long id;
    String title;
    Author author;
    Genre genre;

    @Override
    public String toString() {
        return "Книга: '" + title + "'" +
                "; Автор: " + author.getFullName() +
                "; Жанр: " + genre.getName();
    }
}
