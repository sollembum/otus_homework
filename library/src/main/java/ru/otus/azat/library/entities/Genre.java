package ru.otus.azat.library.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "genres")
public class Genre {
    @Id
    private String id;

    private String name;

    public Genre(String genreName) {
        this.name = genreName;
    }

    @Override
    public String toString() {
        return "Название жанра: " + name;
    }
}
