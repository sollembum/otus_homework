package ru.otus.azat.library.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.otus.azat.library.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    @EntityGraph(attributePaths = {"author", "genre"})
    List<Book> findAll();
    @EntityGraph(attributePaths = {"author", "genre"})
    Optional<Book> findBookById(Long id);
    @Modifying
    @Query("update Book b set b.title = :title where b.id = :id")
    void updateTitleById(@Param("title")String newTitle, @Param("id") Long id);
    Optional<Book> findByTitle(String title);
}
