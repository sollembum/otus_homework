package ru.otus.azat.library.entityServices;

import org.springframework.transaction.annotation.Transactional;
import ru.otus.azat.library.entities.BookComment;

import java.util.List;

public interface BookCommentService {
    BookComment saveComment(String comment,long bookId);

    List<BookComment> findCommentsByBook(long BookId);

    @Transactional
    BookComment updComment(long id, String comment);

    @Transactional
    void deleteComment(long id);
}
