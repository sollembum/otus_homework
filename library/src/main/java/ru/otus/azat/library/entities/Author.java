package ru.otus.azat.library.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Author {
    Long id;
    String fullName;

    @Override
    public String toString() {
        return "Имя автора: " + fullName;
    }
}
