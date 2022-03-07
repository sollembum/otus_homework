package ru.otus.azat.library.services;

import ru.otus.azat.library.entities.BookComment;
import ru.otus.azat.library.repositories.BookCommentRepository;

public class BookCommentServiceImpl implements BookCommentService{
    private final BookCommentRepository bookCommentRepository;

    public BookCommentServiceImpl(BookCommentRepository bookCommentRepository) {
        this.bookCommentRepository = bookCommentRepository;
    }

    @Override
    public BookComment saveComment(String comment, Long book_id) {
        return null;
    }
}
