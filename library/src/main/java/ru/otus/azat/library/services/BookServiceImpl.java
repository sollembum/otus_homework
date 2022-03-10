package ru.otus.azat.library.services;

import org.springframework.stereotype.Service;
import ru.otus.azat.library.dao.BookDao;
import ru.otus.azat.library.entities.Book;
import ru.otus.azat.library.exceptions.AuthorException;
import ru.otus.azat.library.exceptions.BookException;
import ru.otus.azat.library.exceptions.GenreException;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final GenreService genreService;
    private final AuthorService authorService;
    private final BookDao bookDao;

    public BookServiceImpl(GenreService genreService, AuthorService authorService, BookDao bookDao) {
        this.genreService = genreService;
        this.authorService = authorService;
        this.bookDao = bookDao;
    }

    @Override
    public Book createNewBook(String title, String authorFullName, String genreName) {
        try {
            Book newBook = new Book();
            newBook.setTitle(title);
            newBook.setAuthor(authorService.getAuthor(authorFullName));
            newBook.setGenre(genreService.getGenre(genreName));
            bookDao.create(newBook);
            return newBook;
        }
        catch (AuthorException e){
            throw new AuthorException("We don't have that author", e);
        }
        catch (GenreException e){
            throw new GenreException("We don't have that genre", e);
        }
    }
    @Override
    public String updateBook(Long id, String value){
        if (bookDao.updateById(id, value) == 0){
            return "We don't have that book id";
        }
        return bookDao.getById(id).toString();
    }
    @Override
    public String deleteBook(Long id){
        if (bookDao.deleteById(id) == 0){
            return "We don't have that book id";
        }
        return "That book was deleted";
    }
    @Override
    public Book findBook(Long id){
        try {
            return bookDao.getById(id);
        } catch (Exception e) {
            throw new BookException("We don't have that book id", e) ;
        }
    }
    @Override
    public List<Book> findAllBooks(){
        return bookDao.getAll();
    }
    @Override
    public int countBooks(){
      return bookDao.count();
    }
}
