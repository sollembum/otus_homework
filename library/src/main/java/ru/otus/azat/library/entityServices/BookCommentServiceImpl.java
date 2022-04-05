package ru.otus.azat.library.entityServices;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.azat.library.entities.BookComment;
import ru.otus.azat.library.repositories.BookCommentRepCustom;
import ru.otus.azat.library.repositories.BookCommentRepository;

import java.util.List;

@Service
public class BookCommentServiceImpl implements BookCommentService{
    private final BookCommentRepCustom bookCommentRepCustom;
    private final BookCommentRepository bookCommentRepository;
    private final BookService bookService;

    public BookCommentServiceImpl(BookCommentRepCustom bookCommentRepCustom,
                                  BookCommentRepository bookCommentRepository, BookService bookService) {
        this.bookCommentRepCustom = bookCommentRepCustom;
        this.bookCommentRepository = bookCommentRepository;
        this.bookService = bookService;
    }
    @Transactional
    @Override
    public BookComment saveComment(String comment, String bookId) {
        BookComment bc = new BookComment();
        bc.setComment(comment);
        bc.setBook(bookService.findBook(bookId));
        return bookCommentRepository.save(bc);
    }
    @Transactional(readOnly = true)
    @Override
    public List<BookComment> findComments(){
       return bookCommentRepository.findAll();
    }
    @Transactional
    @Override
    public void updComment(String id, String comment){
        bookCommentRepCustom.updateComment(id, comment);
    }
    @Transactional
    @Override
    public void deleteComment(String id){
        bookCommentRepository.deleteById(id);
    }
}
