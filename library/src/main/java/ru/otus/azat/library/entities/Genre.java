package ru.otus.azat.library.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Genre {
    Long id;
    String name;

    @Override
    public String toString() {
        return "Название жанра: " + name;
    }
}
