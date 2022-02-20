package ru.otus.azat.library.repositories;


import org.springframework.stereotype.Repository;
import ru.otus.azat.library.entities.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class AuthorRepositoryJpa implements AuthorRepository {

    @PersistenceContext
    private final EntityManager em;

    public AuthorRepositoryJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public Author getByName(String name) {
        return null;
    }

    @Override
    public List<Author> getAll() {
        return em.createQuery("select s from Author s",
                Author.class).getResultList();
    }
}
