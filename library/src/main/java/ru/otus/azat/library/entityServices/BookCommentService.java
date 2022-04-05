package ru.otus.azat.library.entityServices;

import ru.otus.azat.library.entities.BookComment;

import java.util.List;

public interface BookCommentService {
    BookComment saveComment(String comment,String bookId);

    List<BookComment> findComments();


    void updComment(String id, String comment);


    void deleteComment(String id);
}
