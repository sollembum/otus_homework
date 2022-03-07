package ru.otus.azat.library.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @ManyToOne(targetEntity = Author.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne(targetEntity = Genre.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @OneToMany(targetEntity = BookComment.class,
            fetch = FetchType.EAGER , cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "book_id")
    private List<BookComment> bookComments;

    @Override
    public String toString() {
        String noCommentBook = "Книга: '" + title + "' " + author.toString() + genre.toString();
        if (bookComments == null){
            return noCommentBook + System.lineSeparator();
        }else {
            return noCommentBook + bookComments + System.lineSeparator();
        }
    }
}
