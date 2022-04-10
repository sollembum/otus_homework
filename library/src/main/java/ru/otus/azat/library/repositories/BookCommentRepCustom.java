package ru.otus.azat.library.repositories;

import ru.otus.azat.library.entities.Book;

public interface BookCommentRepCustom {
    void updateComment(String id, String feedback);
    void updateCommentsBook(Book oldBook, Book newBook);
}
