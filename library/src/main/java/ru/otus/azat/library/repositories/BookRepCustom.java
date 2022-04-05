package ru.otus.azat.library.repositories;

import ru.otus.azat.library.entities.BookComment;

import java.util.List;

public interface BookRepCustom {
    void updateTitleById(String id, String newTitle);
    List<BookComment> findAllCommentsByBookTitle(String bookTitle);
}
