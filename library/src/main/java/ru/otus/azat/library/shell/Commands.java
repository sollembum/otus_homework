package ru.otus.azat.library.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.azat.library.dao.AuthorDao;
import ru.otus.azat.library.dao.BookDao;
import ru.otus.azat.library.dao.GenreDao;
import ru.otus.azat.library.entities.Book;
import ru.otus.azat.library.services.BookService;

@ShellComponent
public class Commands {
    private final BookService bookService;
    private final BookDao bookDao;
    private final GenreDao genreDao;
    private final AuthorDao authorDao;
    public Commands(BookService bookService, BookDao bookDao, GenreDao genreDao, AuthorDao authorDao) {
        this.bookService = bookService;
        this.bookDao = bookDao;
        this.genreDao = genreDao;
        this.authorDao = authorDao;
    }
    @ShellMethod(value = "Create new book", key = {"create"})
    public String createBook(String title, String authorFullName, String genreName){
        Book book = bookService.createNewBook(title, authorFullName, genreName);
        return bookDao.create(book);
    }
    @ShellMethod(value = "Books count", key = {"cnt", "count"})
    public String countBooks(){
        return String.valueOf(bookDao.count());
    }

    @ShellMethod(value = "Update book by id", key = {"upd", "updTitle"})
    public String updTitle(Long id, String value){
        return bookDao.updateById(id,value);
    }

    @ShellMethod(value = "Delete book by id", key = {"delete", "deleteBook"})
    public String deleteBookById(Long id){
        return bookDao.deleteById(id);
    }

    @ShellMethod(value = "Find book by id", key = {"find", "findBook"})
    public String getBookById(Long id){
        return bookDao.getById(id).toString();
    }

    @ShellMethod(value = "Show Books", key = {"books", "b"})
    public String showAllBooks(){
        return bookDao.getAll().toString();
    }

    @ShellMethod(value = "Show Genres", key = {"genres", "g"})
    public String showAllGenres(){
        return genreDao.getAll().toString();
    }

    @ShellMethod(value = "Show Authors", key = {"authors", "a"})
    public String showAllAuthors(){
        return authorDao.getAll().toString();
    }
}
