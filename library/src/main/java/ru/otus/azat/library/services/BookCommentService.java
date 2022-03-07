package ru.otus.azat.library.services;

import ru.otus.azat.library.entities.BookComment;

public interface BookCommentService {
    BookComment saveComment(String comment, Long book_id);
}
