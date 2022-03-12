package ru.otus.azat.library.repositories;

import ru.otus.azat.library.entities.BookComment;

import java.util.List;

public interface BookCommentRepository {
    BookComment save(BookComment comment);
    BookComment findById(long id);

    List<BookComment> findAll();

    BookComment updateCommentById(long id, String name);
    void deleteById(long id);
}
