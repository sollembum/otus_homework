package ru.otus.azat.library.dao;

import ru.otus.azat.library.entity.Book;

import java.util.List;

public interface BookDao {
    void create(Book book);
    void update();
    void deleteById(long id);
    Book getById(long id);
    List<Book> getAll();
}
