package ru.otus.azat.library.dao;

import ru.otus.azat.library.entities.Book;

import java.util.List;

public interface BookDao {
    int count();
    Book create(Book book);
    int updateById(Long id, String value);
    int deleteById(Long id);
    Book getById(Long id);
    List<Book> getAll();
}
