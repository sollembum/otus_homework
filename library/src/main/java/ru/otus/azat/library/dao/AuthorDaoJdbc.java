package ru.otus.azat.library.dao;


import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.azat.library.entities.Author;
import ru.otus.azat.library.exceptions.AuthorException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class AuthorDaoJdbc implements AuthorDao{
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public AuthorDaoJdbc(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }
    @Override
    public List<Author> getAll() {
        return namedParameterJdbcOperations.query("select id, fullname from authors",
                new AuthorDaoJdbc.AuthorMapper());
    }

    @Override
    public Author getByName(String name){
            try {
                Map<String, Object> params = Collections.singletonMap("name", name);
                return namedParameterJdbcOperations.queryForObject("select id, fullname from authors where fullname = :name",
                        params, new AuthorMapper());
            }catch (Exception e){
                throw new AuthorException();
            }

    }

    private static class AuthorMapper implements RowMapper<Author> {

        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            Long id = rs.getLong("id");
            String fullname = rs.getString("fullname");
            return new Author(id, fullname);
        }
    }
}
