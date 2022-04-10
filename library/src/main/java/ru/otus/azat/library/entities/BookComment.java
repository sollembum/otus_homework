package ru.otus.azat.library.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "book_comments")
public class BookComment {
    @Id
    private String id;

    private String comment;

    private Book book;

    public BookComment(String feedback) {
        this.comment = feedback;
    }

    public BookComment(String comment, Book book) {
        this.book = book;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Комментарий: " + comment;
    }
}
