package ru.otus.azat.library.repositories;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.azat.library.entities.Author;
import ru.otus.azat.library.entities.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AuthorRepositoryJpa implements AuthorRepository {

    @PersistenceContext
    private final EntityManager em;

    public AuthorRepositoryJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public Author getByName(String fullname) {
        TypedQuery<Author> query = em.createQuery("select s from Author s where s.fullName = :fullname",
                Author.class);
        query.setParameter("fullname", fullname);
        return query.getSingleResult();
    }

    @Override
    public List<Author> getAll() {
        return em.createQuery("select s from Author s",
                Author.class).getResultList();
    }
}
