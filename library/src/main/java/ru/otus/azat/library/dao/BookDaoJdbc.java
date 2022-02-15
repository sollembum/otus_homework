package ru.otus.azat.library.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import ru.otus.azat.library.entities.Author;
import ru.otus.azat.library.entities.Book;
import ru.otus.azat.library.entities.Genre;

@Repository
public class BookDaoJdbc implements BookDao{
    private final JdbcOperations jdbc;
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    private final GenreDao genreDao;
    private final AuthorDao authorDao;

    public BookDaoJdbc(JdbcOperations jdbc, NamedParameterJdbcOperations namedParameterJdbcOperations,
                       GenreDao genreDao, AuthorDao authorDao) {
        this.jdbc = jdbc;
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
        this.genreDao = genreDao;
        this.authorDao = authorDao;
    }

    @Override
    public int count() {
        Integer count = jdbc.queryForObject("select count(*) from books", Integer.class);
        return count == null ? 0 : count;
    }

    @Override
    public String create(Book book) {
            namedParameterJdbcOperations.update("insert into books (id, title, author_id, genre_id) values (:id, :title, :author_id, :genre_id)",
                    Map.of("id", book.getId(),
                            "title", book.getTitle(),
                            "author_id", book.getAuthor().getId(),
                            "genre_id", book.getGenre().getId()));
        return book + " was created!";
    }

    @Override
    public String updateById(Long id, String value) {
        if (namedParameterJdbcOperations.update("update books set title = :value where id in (:id)",
                    Map.of("id", id,
                    "value", value)) == 0){
            return "We don't have that book id!";
        }else{
            return "Book title was updated!";
        }
    }

    @Override
    public String deleteById(Long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        if(namedParameterJdbcOperations.update(
                "delete from books where id = :id", params
        )==0){
            return "We don't have that book id!";
        }else {
            return "Book was deleted!";
        }
    }

    @Override
    public Book getById(Long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return namedParameterJdbcOperations.queryForObject("select books.id, books.title, " +
                        "authors.fullname as authors_fullname, authors.id as authors_id, " +
                        "genres.name as genres_name, genres.id as genres_id " +
                        "from books " +
                        "join authors on books.author_id = authors.id " +
                        "join genres on books.genre_id = genres.id " +
                        "where books.id = :id", params, new BookMapper()
        );
    }

    @Override
    public List<Book> getAll() {
        return namedParameterJdbcOperations.query("select books.id, books.title, " +
                        "authors.fullname as authors_fullname, authors.id as authors_id, " +
                        "genres.name as genres_name, genres.id as genres_id " +
                "from books " +
                "join authors on books.author_id = authors.id " +
                "join genres on books.genre_id = genres.id"
                , new BookMapper());
    }

    private static class BookMapper implements RowMapper<Book>{

        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            Long id = rs.getLong("id");
            String title = rs.getString("title");
            Author author = new Author(rs.getLong("authors_id"), rs.getString("authors_fullname"));
            Genre genre = new Genre (rs.getLong("genres_id"), rs.getString("genres_name"));
            return new Book(id, title, author, genre);
        }
    }
}
