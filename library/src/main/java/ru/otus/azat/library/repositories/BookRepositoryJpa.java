package ru.otus.azat.library.repositories;

import org.springframework.stereotype.Repository;
import ru.otus.azat.library.entities.Book;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;


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
    public Book findById(long id) {
        TypedQuery<Book> query = em.createQuery("select s from Book s join fetch s.author join fetch s.genre " +
                "where s.id = :id", Book.class);
        query.setParameter("id", id);
        return query.getResultList().get(0);
    }


    @Override
    public List<Book> findAll() {
        return em.createQuery("select s from Book s join fetch s.author join fetch s.genre",
                Book.class).getResultList();
    }

    /*@Override
    public List<Book> findByName(String title) {
        TypedQuery<Book> query = em.createQuery("select s " +
                        "from Book s " +
                        "where s.title = :title",
                Book.class);
        query.setParameter("title", title);
        return query.getResultList();
    }*/

    @Override
    public Book updateNameById(long id, String title) {
        Query query = em.createQuery("update Book s " +
                "set s.title = :title " +
                "where s.id = :id");
        query.setParameter("title", title);
        query.setParameter("id", id);
        query.executeUpdate();
        return findById(id);
    }

    @Override
    public void deleteById(long id) {
        Query query = em.createQuery("delete " +
                "from Book s " +
                "where s.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
