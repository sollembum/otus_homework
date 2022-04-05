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
@Document(collection = "authors")
public class Author {
    @Id
    private String id;

    private String fullName;

    public Author(String authorFullName) {
        this.fullName = authorFullName;
    }

    @Override
    public String toString() {
        return "Имя автора: " + fullName + " ";
    }
}
