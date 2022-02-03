package ru.otus.azat.library.dao;

import ru.otus.azat.library.entity.Book;

import java.util.List;

public interface BookDao {
    void create();
    void update();
    void delete();
    Book getById(long id);
    List<Book> getAll();
}
