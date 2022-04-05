package ru.otus.azat.library.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.otus.azat.library.entities.BookComment;

import java.util.List;

public interface BookCommentRepository extends CrudRepository<BookComment, String> {
    List<BookComment> findAll();
}
