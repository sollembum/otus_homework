package ru.otus.azat.library.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.azat.library.dao.AuthorDao;
import ru.otus.azat.library.dao.BookDao;
import ru.otus.azat.library.dao.GenreDao;

@ShellComponent
public class Commands {
    private final BookDao bookDao;
    private final GenreDao genreDao;
    private final AuthorDao authorDao;
    public Commands(BookDao bookDao, GenreDao genreDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.genreDao = genreDao;
        this.authorDao = authorDao;
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
