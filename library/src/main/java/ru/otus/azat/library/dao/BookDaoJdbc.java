package ru.otus.azat.library.dao;

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
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    private final GenreDao genreDao;
    private final AuthorDao authorDao;

    private List<Author> authors;
    private List<Genre> genres;

    public BookDaoJdbc(NamedParameterJdbcOperations namedParameterJdbcOperations,
                       GenreDao genreDao, AuthorDao authorDao) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
        this.genreDao = genreDao;
        this.authorDao = authorDao;
        init();
    }
    public void init(){
        authors = authorDao.getAll();
        genres = genreDao.getAll();
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
    public String updateById(Long id, String value) {
        try{
            namedParameterJdbcOperations.update("update books set title = :value where id in (:id)",
                    Map.of("id", id,
                    "value", value));
            return "Book title was updated!";
        }catch (Exception e){
            return e.getMessage() + System.lineSeparator() +
                    "U may misspelled book column";
        }
    }

    @Override
    public String deleteById(Long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        namedParameterJdbcOperations.update(
                "delete from books where id = :id", params
        );
        return "Book was deleted!";
    }

    @Override
    public Book getById(Long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return namedParameterJdbcOperations.queryForObject(
                "select id, title, author_id, genre_id from books where id = :id", params, new BookMapper(genres, authors)
        );    }

    @Override
    public List<Book> getAll() {
        return namedParameterJdbcOperations.query("select id, title, author_id, genre_id from books", new BookMapper(genres, authors));
    }

    private static class BookMapper implements RowMapper<Book>{
        List<Genre> genres;
        List<Author> authors;

        private BookMapper(List<Genre> genres, List<Author> authors) {
            this.genres = genres;
            this.authors = authors;
        }

        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            Long id = rs.getLong("id");
            String title = rs.getString("title");
            Long a_id = rs.getLong("author_id");
            Long g_id = rs.getLong("genre_id");
            Author author = authors.stream().filter(
                    a -> a.getId().equals(a_id)
            ).findFirst().get();
            Genre genre = genres.stream().filter(
                    g -> g.getId().equals(g_id)
            ).findFirst().get();
            return new Book(id, title, author, genre);
        }
    }
}
