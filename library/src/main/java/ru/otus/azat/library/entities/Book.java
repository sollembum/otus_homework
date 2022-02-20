package ru.otus.azat.library.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @ManyToOne(targetEntity = Author.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne(targetEntity = Genre.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @OneToOne
    @JoinColumn(name = "comment_id")
    private BookComment bookComment;

    @Override
    public String toString() {
        String noCommentBook = "Книга: '" + title + "' " + author.toString() + genre.toString();
        if (bookComment == null){
            return noCommentBook + System.lineSeparator();
        }else {
            return noCommentBook + bookComment + System.lineSeparator();
        }
    }
}
