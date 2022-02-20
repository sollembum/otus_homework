package ru.otus.azat.library.services;

import org.springframework.stereotype.Service;
import ru.otus.azat.library.repositories.GenreRepository;
import ru.otus.azat.library.entities.Genre;
import ru.otus.azat.library.exceptions.GenreException;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService{
    private final GenreRepository genreDao;

    public GenreServiceImpl(GenreRepository genreDao) {
        this.genreDao = genreDao;
    }
    @Override
    public Genre getGenre(String name){
        try {
            return genreDao.getByName(name);
        }catch (GenreException e){
            throw new GenreException();
        }
    }
    @Override
    public List<Genre> getAllGenres(){
        return genreDao.getAll();
    }
}
