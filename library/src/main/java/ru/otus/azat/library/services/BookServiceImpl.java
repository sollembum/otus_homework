package ru.otus.azat.library.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.azat.library.entities.Author;
import ru.otus.azat.library.entities.Genre;
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

    public BookServiceImpl(GenreService genreService, AuthorService authorService, BookRepository bookRepository) {
        this.genreService = genreService;
        this.authorService = authorService;
        this.bookRepository = bookRepository;
    }
    @Transactional
    @Override
    public Book createNewBook(String title, String authorFullName, String genreName) {
        try {
            Book newBook = new Book();
            newBook.setTitle(title);
            newBook.setAuthor(authorService.getAuthor(authorFullName));
            newBook.setGenre(genreService.getGenre(genreName));
            //newBook.setBookComments(bookRepository.findAllCommentsById(1L));
            bookRepository.save(newBook);
            return newBook;
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
    public void updateBook(long id, String value){
        bookRepository.updateNameById(id, value);
    }
    @Transactional
    @Override
    public void deleteBook(long id){
        bookRepository.deleteById(id) ;
    }
    @Transactional(readOnly = true)
    @Override
    public Book findBook(long id){
        try {
            return bookRepository.findById(id);
        } catch (Exception e) {
            throw new BookException("We don't have that book id", e) ;
        }
    }
    @Transactional(readOnly = true)
    @Override
    public List<Book> findAllBooks(){
       return bookRepository.findAll();
    }
    @Override
    public int countBooks(){
      //return bookRepository.count();
        return 0;
    }
}
