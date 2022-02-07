package ru.otus.azat.library.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.azat.library.entity.Author;
import ru.otus.azat.library.entity.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class BookDaoJdbc implements BookDao{
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public BookDaoJdbc(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    @Override
    public void create(Book book) {
        namedParameterJdbcOperations.update("insert into books (id, title, author_id, genre_id) values (:id, :title, :author_id, :genre_id)",
                Map.of("id", book.getId(),
                        "title", book.getTitle(),
                        "author_id", book.getAuthor().getId(),
                        "genre_id", book.getGenre().getId()));
    }

    @Override
    public void update() {

    }

    @Override
    public void deleteById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        namedParameterJdbcOperations.update(
                "delete from books where id = :id", params
        );
    }

    @Override
    public Book getById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return namedParameterJdbcOperations.queryForObject(
                "select id, name from books where id = :id", params, new BookMapper()
        );    }

    @Override
    public List<Book> getAll() {
        return namedParameterJdbcOperations.query("select id, name from books", new BookMapper());
    }

    private static class BookMapper implements RowMapper<Book>{

        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id = rs.getLong("id");
            String title = rs.getString("title");
            //здесь надо сделать запросы в authors и genre таблицы, вытащить названия по айдишникам?
            //т.е. здесь надо вызвать getById у AuthorDao и у GenreDao
            return new Book(id, title, );
        }
    }
}
