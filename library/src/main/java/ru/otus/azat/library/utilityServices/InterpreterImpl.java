package ru.otus.azat.library.utilityServices;

import org.springframework.stereotype.Service;
import ru.otus.azat.library.entities.Author;
import ru.otus.azat.library.entities.Book;
import ru.otus.azat.library.entities.BookComment;
import ru.otus.azat.library.entities.Genre;

import java.util.List;

@Service
public class InterpreterImpl implements Interpreter{
    @Override
    public String showToUser(Object o){
        if (o instanceof Book) {
            Book book = (Book) o;
            return "Книга - " + book.getTitle() + ", "
                    + showToUser(book.getAuthor()) + ", "
                    + showToUser(book.getGenre());
        } else if (o instanceof Author) {
            Author author = (Author) o;
            return "Автор - " + author.getFullName();
        } else if (o instanceof Genre){
            Genre genre = (Genre) o;
            return "Жанр - " + genre.getName();
        } else if (o instanceof List){
            StringBuilder sb = new StringBuilder();
            for (Object object:(List) o) {
                sb.append(showToUser(object));
                sb.append(System.lineSeparator());
            }
            return sb.toString();
        }else if (o instanceof BookComment){
            BookComment comment = (BookComment) o;
            return "Комментарий - " + comment.getComment() + ", "
                    + "Книга - " + comment.getBook().getTitle();
        }
        return "Can't interpret that object";
    }
}
