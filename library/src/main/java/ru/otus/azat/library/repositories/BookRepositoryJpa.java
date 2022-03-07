package ru.otus.azat.library.repositories;

import lombok.val;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.azat.library.entities.Book;
import ru.otus.azat.library.entities.BookComment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;


@Repository
public class BookRepositoryJpa implements BookRepository{
    @PersistenceContext
    private final EntityManager em;

    public BookRepositoryJpa(EntityManager em) {
        this.em = em;
    }

    @Transactional
    @Override
    public Book save(Book book) {
        if (book.getId() <= 0){
            em.persist(book); //почему-то объект автора detached
            return book;
        }else {
            return em.merge(book);
        }
    }
    @Transactional(readOnly = true)
    @Override
    public Book findById(long id) {
        return Optional.ofNullable(em.find(Book.class, id)).get();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> findAll() {
        return em.createQuery("select s from Book s",
                Book.class).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> findByName(String title) {
        TypedQuery<Book> query = em.createQuery("select s " +
                        "from Book s " +
                        "where s.title = :title",
                Book.class);
        query.setParameter("title", title);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void updateNameById(long id, String title) {
        Query query = em.createQuery("update Book s " +
                "set s.title = :title " +
                "where s.id = :id");
        query.setParameter("title", title);
        query.setParameter("id", id);
        query.executeUpdate();
    }
    @Transactional
    @Override
    public boolean addComment(long bookId, String feedback) {
        val bookComments = findById(bookId).getBookComments();
        BookComment comment = new BookComment(feedback);
        return bookComments.add(comment);
    }
    @Override
    public List<BookComment> findAllCommentsById(long id) {
        val book = em.find(Book.class, id);
        return book.getBookComments();
    }
    @Transactional
    @Override
    public void deleteById(long id) {
        Query query = em.createQuery("delete " +
                "from Book s " +
                "where s.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
