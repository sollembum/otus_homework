package ru.otus.azat.library.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.azat.library.entities.BookComment;

import java.util.List;

public interface BookCommentRepository extends JpaRepository<BookComment, Long> {
    @EntityGraph(attributePaths = {"book"})
    List<BookComment> findByBook_Id(long bookId);
}
