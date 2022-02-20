package ru.otus.azat.library.repositories;

import org.springframework.stereotype.Repository;
import ru.otus.azat.library.entities.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class GenreRepositoryJpa implements GenreRepository {


    @PersistenceContext
    private final EntityManager em;

    public GenreRepositoryJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public Genre getByName(String name) {
        TypedQuery<Genre> query = em.createQuery("select s from Genre s where s.name = :name",
                Genre.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @Override
    public List<Genre> getAll() {
        return em.createQuery("select s from Genre s",
                Genre.class).getResultList();
    }
}
