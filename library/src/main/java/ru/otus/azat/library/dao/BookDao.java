package ru.otus.azat.library.dao;

import ru.otus.azat.library.entities.Book;

import java.util.List;

public interface BookDao {
    public int count();
    String create(Book book);
    String updateById(Long id, String value);
    String deleteById(Long id);
    Book getById(Long id);
    List<Book> getAll();
}
