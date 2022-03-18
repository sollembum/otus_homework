package ru.otus.azat.library.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.otus.azat.library.entities.BookComment;

import java.util.List;

public interface BookCommentRepository extends JpaRepository<BookComment, Long> {
    @EntityGraph(attributePaths = {"book"})
    List<BookComment> findByBook_Id(long bookId);
    @Modifying
    @Query("update BookComment bc set bc.comment = :newComment where bc.id = :id")
    void updateBookCommentById(@Param("newComment")String newComment, @Param("id")Long id);
}
