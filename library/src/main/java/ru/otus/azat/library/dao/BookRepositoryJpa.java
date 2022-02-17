package ru.otus.azat.library.dao;

import org.springframework.stereotype.Repository;
import ru.otus.azat.library.entities.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryJpa implements BookRepository{
    @PersistenceContext
    private final EntityManager em;

    public BookRepositoryJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public Book save(Book student) {
        return null;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public List<Book> findByName(String name) {
        return null;
    }

    @Override
    public void updateNameById(Long id, String name) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
