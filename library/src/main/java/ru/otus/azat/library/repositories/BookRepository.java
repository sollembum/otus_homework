package ru.otus.azat.library.repositories;

import org.springframework.transaction.annotation.Transactional;
import ru.otus.azat.library.entities.Book;
import ru.otus.azat.library.entities.BookComment;

import java.util.List;

public interface BookRepository {
    Book save(Book student);
    Book findById(long id);

    List<Book> findAll();
    List<Book> findByName(String name);

    void updateNameById(long id, String name);

    @Transactional
    boolean addComment(long bookId, String feedback);

    List<BookComment> findAllCommentsById(long id);

    void deleteById(long id);
}
