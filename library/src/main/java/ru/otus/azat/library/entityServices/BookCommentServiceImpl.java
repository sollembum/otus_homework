package ru.otus.azat.library.entityServices;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.azat.library.entities.BookComment;
import ru.otus.azat.library.repositories.BookCommentRepository;

import java.util.List;

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
        return bookCommentRepository.save(bc);
    }
    @Transactional(readOnly = true)
    @Override
    public List<BookComment> findCommentsByBook(long bookId){
       return bookCommentRepository.findCommentsByBook(bookId);
    }
    @Transactional
    @Override
    public BookComment updComment(long id, String comment){
        return bookCommentRepository.updateCommentById(id, comment);
    }
    @Transactional
    @Override
    public void deleteComment(long id){
        bookCommentRepository.deleteById(id);
    }
}
