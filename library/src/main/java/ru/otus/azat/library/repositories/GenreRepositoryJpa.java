package ru.otus.azat.library.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.azat.library.entities.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class GenreRepositoryJpa implements GenreRepository {


    @PersistenceContext
    private final EntityManager em;

    public GenreRepositoryJpa(EntityManager em) {
        this.em = em;
    }

    @Transactional(readOnly = true)
    @Override
    public Genre getByName(String name) {
        TypedQuery<Genre> query = em.createQuery("select s from Genre s where s.name = :name",
                Genre.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Genre> getAll() {
        return em.createQuery("select s from Genre s",
                Genre.class).getResultList();
    }
}