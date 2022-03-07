package ru.otus.azat.library.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.azat.library.entities.Author;
import ru.otus.azat.library.entities.Book;
import ru.otus.azat.library.entities.Genre;
import ru.otus.azat.library.services.AuthorService;
import ru.otus.azat.library.services.BookService;
import ru.otus.azat.library.services.GenreService;

import java.util.List;

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
    @ShellMethod(value = "Create new comment", key = {"cc"})
    public String createComment(String comment, Long book_id){
        return "хз";
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
        StringBuilder message = new StringBuilder();
        List<Book> lob = bookService.findAllBooks();
        for (Book book : lob){
            message.append("Id книги = " + book.getId() +
                    ", Заголовок книги = " + book.getTitle() +
                    ", Автор книги = " + book.getAuthor().getFullName() +
                    ", Жанр книги = " + book.getGenre().getName());
            if (book.getBookComments() == null){
                message.append(System.lineSeparator());
            }else{
                message.append(", Комментарий = " + book.getBookComments().toString() +
                        System.lineSeparator());
            }
        }
        return message.toString();
    }

    @ShellMethod(value = "Show Genres", key = {"genres", "g"})
    public String showAllGenres(){
        StringBuilder message = new StringBuilder();
        List<Genre> log = genreService.getAllGenres();
        for (Genre genre : log){
            message.append("Id жанра = " + genre.getId() +
                    ", Название жанра = " + genre.getName() +
                    System.lineSeparator());
        }
        return message.toString();
    }

    @ShellMethod(value = "Show Authors", key = {"authors", "a"})
    public String showAllAuthors(){
        StringBuilder message = new StringBuilder();
        List<Author> loa = authorService.getAllAuthors();
        for (Author author : loa){
            message.append("Id автора = " + author.getId() +
                    ", Имя автора = " + author.getFullName() +
                    System.lineSeparator());
        }
        return message.toString();
    }
}
