package ru.otus.azat.library.repositories;

import org.springframework.stereotype.Repository;
import ru.otus.azat.library.entities.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class BookRepositoryJpa implements BookRepository{
    @PersistenceContext
    private final EntityManager em;

    public BookRepositoryJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public Book save(Book book) {
        if (book.getId() <= 0){
            em.persist(book);
            return book;
        }else {
            return em.merge(book);
        }
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(em.find(Book.class, id));
    }

    @Override
    public List<Book> findAll() {
        return em.createQuery("select s from Book s",
                Book.class).getResultList();
    }

    @Override
    public List<Book> findByName(String title) {
        TypedQuery<Book> query = em.createQuery("select s " +
                        "from Book s " +
                        "where s.title = :title",
                Book.class);
        query.setParameter("title", title);
        return query.getResultList();
    }

    @Override
    public void updateNameById(Long id, String title) {
        Query query = em.createQuery("update Book s " +
                "set s.title = :title " +
                "where s.id = :id");
        query.setParameter("title", title);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void deleteById(Long id) {
        Query query = em.createQuery("delete " +
                "from Book s " +
                "where s.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
