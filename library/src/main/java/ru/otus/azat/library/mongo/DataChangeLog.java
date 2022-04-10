package ru.otus.azat.library.mongo;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import ru.otus.azat.library.entities.Author;
import ru.otus.azat.library.entities.Book;
import ru.otus.azat.library.entities.BookComment;
import ru.otus.azat.library.entities.Genre;
import ru.otus.azat.library.entityServices.BookService;
import ru.otus.azat.library.repositories.AuthorRepository;
import ru.otus.azat.library.repositories.BookCommentRepository;
import ru.otus.azat.library.repositories.BookRepository;

@ChangeLog
public class DataChangeLog {
    @ChangeSet(order = "001", id = "dropDb", runAlways = true, author = "azat")
    public void dropDb(MongoDatabase db) {
        db.drop();
    }
    @ChangeSet(order = "002", id = "insertGenres", author = "azat")
    public void insertDrama(MongoDatabase db) {
        MongoCollection<Document> myCollection = db.getCollection("genres");
        var doc = new Document().append("name", "drama");
        myCollection.insertOne(doc);
        var doc1 = new Document().append("name", "horror");
        myCollection.insertOne(doc1);
    }
    @ChangeSet(order = "003", id = "insertAuthors", author = "azat")
    public void insertAuthors(AuthorRepository repository) {
        Author pushkin = new Author("Pushkin");
        Author lermontov = new Author("Lermontov");
        repository.save(pushkin);
        repository.save(lermontov);
    }
    @ChangeSet(order = "004", id = "insertBooks", author = "azat")
    public void insertBook(BookRepository repository) {
        Book book = new Book();
        book.setTitle("3pigs");
        book.setAuthor(new Author("Pushkin"));
        book.setGenre(new Genre("drama"));
        repository.save(book);
    }
    @ChangeSet(order = "005", id = "insertComments", author = "azat")
    public void insertComments(BookCommentRepository bcRepository, BookRepository bookRepository) {
        Book book = bookRepository.findByTitle("3pigs").get();
        BookComment comment = new BookComment("good", book);
        bcRepository.save(comment);
    }
}
