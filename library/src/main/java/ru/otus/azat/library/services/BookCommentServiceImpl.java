package ru.otus.azat.library.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.azat.library.entities.BookComment;
import ru.otus.azat.library.repositories.BookCommentRepository;

@Service
public class BookCommentServiceImpl implements BookCommentService{
    private final BookCommentRepository bookCommentRepository;
    private final BookService bookService;

    public BookCommentServiceImpl(BookCommentRepository bookCommentRepository, BookService bookService) {
        this.bookCommentRepository = bookCommentRepository;
        this.bookService = bookService;
    }
    @Transactional
    @Override
    public BookComment saveComment(String comment, long bookId) {
        BookComment bc = new BookComment();
        bc.setComment(comment);
        bc.setBook(bookService.findBook(bookId));
        bookCommentRepository.save(bc);
        return null;
    }
}
