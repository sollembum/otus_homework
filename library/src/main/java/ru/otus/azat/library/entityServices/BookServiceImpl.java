package ru.otus.azat.library.entityServices;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.azat.library.repositories.BookCommentRepository;
import ru.otus.azat.library.repositories.BookRepository;
import ru.otus.azat.library.entities.Book;
import ru.otus.azat.library.exceptions.AuthorException;
import ru.otus.azat.library.exceptions.BookException;
import ru.otus.azat.library.exceptions.GenreException;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final GenreService genreService;
    private final AuthorService authorService;
    private final BookRepository bookRepository;
    private final BookCommentRepository commentRepository;

    public BookServiceImpl(GenreService genreService, AuthorService authorService,
                           BookRepository bookRepository, BookCommentRepository commentRepository) {
        this.genreService = genreService;
        this.authorService = authorService;
        this.bookRepository = bookRepository;
        this.commentRepository = commentRepository;
    }
    @Transactional
    @Override
    public Book createNewBook(String title, String authorFullName, String genreName) {
        try {
            Book newBook = new Book();
            newBook.setTitle(title);
            newBook.setAuthor(authorService.getAuthor(authorFullName));
            newBook.setGenre(genreService.getGenre(genreName));
            return bookRepository.save(newBook);
        }
        catch (AuthorException e){
            throw new AuthorException("We don't have that author", e);
        }
        catch (GenreException e){
            throw new GenreException("We don't have that genre", e);
        }
    }
    @Transactional
    @Override
    public void updateBook(String id, String newTitle){
        Book oldBook = bookRepository.findBookById(id).get();
        bookRepository.updateTitleById(id, newTitle);
        Book newBook = bookRepository.findBookById(id).get();
        commentRepository.updateCommentsBook(oldBook, newBook);
    }
    @Transactional
    @Override
    public void deleteBook(String id){
        Book book = bookRepository.findBookById(id).get();
        bookRepository.deleteById(id) ;
        commentRepository.deleteBookCommentByBook(book);
    }

    @Transactional(readOnly = true)
    @Override
    public Book findBook(String id){
        try {
            return bookRepository.findBookById(id).get();
        } catch (Exception e) {
            throw new BookException("We don't have that book id", e) ;
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> findAllBooks(){
       return bookRepository.findAll();
    }

}
