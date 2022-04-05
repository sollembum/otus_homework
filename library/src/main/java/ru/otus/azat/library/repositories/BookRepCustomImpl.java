package ru.otus.azat.library.repositories;


import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import ru.otus.azat.library.entities.Book;
import ru.otus.azat.library.entities.BookComment;

import java.util.List;

@Repository
public class BookRepCustomImpl implements BookRepCustom {

    private final MongoTemplate mongoTemplate;

    public BookRepCustomImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void updateTitleById(String id, String newTitle) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Update upd = new Update();
        upd.set("title", newTitle);
        mongoTemplate.updateFirst(query, upd, Book.class);
    }

    @Override
    public List<BookComment> findAllCommentsByBookTitle(String bookTitle) {
        return null;
    }
}
