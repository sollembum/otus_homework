package ru.otus.azat.library.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.azat.library.entities.Book;
import ru.otus.azat.library.services.AuthorService;
import ru.otus.azat.library.services.BookService;
import ru.otus.azat.library.services.GenreService;

@ShellComponent
public class Commands {
    private final BookService bookService;
    private final GenreService genreService;
    private final AuthorService authorService;

    public Commands(BookService bookService, GenreService genreService, AuthorService authorService) {
        this.bookService = bookService;
        this.genreService = genreService;
        this.authorService = authorService;
    }

    @ShellMethod(value = "Create new book", key = {"create"})
    public String createBook(String title, String authorFullName, String genreName){
        Book book = bookService.createNewBook(title, authorFullName, genreName);
        return book + "was created!";
    }
    @ShellMethod(value = "Books count", key = {"cnt", "count"})
    public String countBooks(){
        return String.valueOf(bookService.countBooks());
    }

    @ShellMethod(value = "Update book by id", key = {"upd", "updTitle"})
    public String updTitle(Long id, String value){
        bookService.updateBook(id, value);
        return "Book was updated!";
    }

    @ShellMethod(value = "Delete book by id", key = {"delete", "deleteBook"})
    public String deleteBookById(Long id){
        bookService.deleteBook(id);
        return "Book was deleted!";
    }

    @ShellMethod(value = "Find book by id", key = {"find", "findBook"})
    public String getBookById(Long id){
        return bookService.findBook(id).toString();
    }

    @ShellMethod(value = "Show Books", key = {"books", "b"})
    public String showAllBooks(){
        return bookService.findAllBooks().toString();
    }

    @ShellMethod(value = "Show Genres", key = {"genres", "g"})
    public String showAllGenres(){
        return genreService.getAllGenres().toString();
    }

    @ShellMethod(value = "Show Authors", key = {"authors", "a"})
    public String showAllAuthors(){
        return authorService.getAllAuthors().toString();
    }
}
