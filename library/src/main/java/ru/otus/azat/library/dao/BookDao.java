package ru.otus.azat.library.dao;

import ru.otus.azat.library.entities.Book;

import java.util.List;

public interface BookDao {
    public int count();
    String create(Book book);
    int updateById(Long id, String value);
    int deleteById(Long id);
    Book getById(Long id);
    List<Book> getAll();
}
