package ru.otus.azat.library.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.azat.library.entityServices.AuthorService;
import ru.otus.azat.library.entityServices.BookCommentService;
import ru.otus.azat.library.entityServices.BookService;
import ru.otus.azat.library.entityServices.GenreService;
import ru.otus.azat.library.utilityServices.Interpreter;

@ShellComponent
public class Commands {
    private final Interpreter interpreter;
    private final BookService bookService;
    private final GenreService genreService;
    private final AuthorService authorService;
    private final BookCommentService bookCommentService;

    public Commands(Interpreter interpreter, BookService bookService, GenreService genreService,
                    AuthorService authorService, BookCommentService bookCommentService) {
        this.interpreter = interpreter;
        this.bookService = bookService;
        this.genreService = genreService;
        this.authorService = authorService;
        this.bookCommentService = bookCommentService;
    }
    @ShellMethod (value = "Update comment", key = {"uc"})
    public String updateComment(String id, String comment){
        bookCommentService.updComment(id, comment);
        return "Was updated!";
    }
    @ShellMethod(value = "Delete comment", key = {"dc"})
    public String deleteComment(String id){
        bookCommentService.deleteComment(id);
        return "Comment was deleted";
    }
    @ShellMethod(value = "Find all comments", key = {"comments"})
    public String getCommentsByBook(){
        return interpreter.showToUser(
                bookCommentService.findComments()
        );
    }
    @ShellMethod(value = "Create new comment", key = {"cc"})
    public String createComment(String comment, String book_id){
        return interpreter.showToUser(
            bookCommentService.saveComment(comment, book_id)
        ) +  " - was created!";
    }
    @ShellMethod(value = "Create new book", key = {"create"})
    public String createBook(String title, String authorFullName, String genreName){
        return interpreter.showToUser(
                bookService.createNewBook(title, authorFullName, genreName)
        )+ " - was created!";
    }

    @ShellMethod(value = "Update book by id", key = {"upd", "updTitle"})
    public String updTitle(String id, String value){
        bookService.updateBook(id, value);
        return "Was updated!";
    }

    @ShellMethod(value = "Delete book by id", key = {"delete", "deleteBook"})
    public String deleteBookById(String id){
        bookService.deleteBook(id);
        return "Book was deleted!";
    }

    @ShellMethod(value = "Find book by id", key = {"find", "findBook"})
    public String getBookById(String id){
        return interpreter.showToUser(
                bookService.findBook(id)
        );
    }

    @ShellMethod(value = "Show Books", key = {"books", "b"})
    public String showAllBooks(){
        return interpreter.showToUser(
                bookService.findAllBooks()
        );
    }

    @ShellMethod(value = "Show Genres", key = {"genres", "g"})
    public String showAllGenres(){
        return interpreter.showToUser(
                genreService.getAllGenres()
        );
    }

    @ShellMethod(value = "Show Authors", key = {"authors", "a"})
    public String showAllAuthors(){
        return interpreter.showToUser(
                authorService.getAllAuthors()
        );
    }
}
