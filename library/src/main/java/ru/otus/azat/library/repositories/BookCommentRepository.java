package ru.otus.azat.library.repositories;

import ru.otus.azat.library.entities.BookComment;

import java.util.Optional;

public interface BookCommentRepository {
    BookComment save(BookComment comment);
    Optional<BookComment> findById(long id);
    void updateCommentById(long id, String name);
    void deleteById(long id);
}
