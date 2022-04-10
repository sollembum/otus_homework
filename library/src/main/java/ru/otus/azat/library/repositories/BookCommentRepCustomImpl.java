package ru.otus.azat.library.repositories;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import ru.otus.azat.library.entities.Book;
import ru.otus.azat.library.entities.BookComment;

@Repository
public class BookCommentRepCustomImpl implements BookCommentRepCustom{

    private final MongoTemplate mongoTemplate;

    public BookCommentRepCustomImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void updateComment(String id, String feedback) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Update upd = new Update();
        upd.set("comment", feedback);
        mongoTemplate.updateFirst(query, upd, BookComment.class);
    }

    @Override
    public void updateCommentsBook(Book oldBook, Book newBook) {
        Query query = new Query();
        query.addCriteria(Criteria.where("book").is(oldBook));
        Update upd = new Update();
        upd.set("book", newBook);
        mongoTemplate.updateMulti(query, upd, BookComment.class);
    }
}
