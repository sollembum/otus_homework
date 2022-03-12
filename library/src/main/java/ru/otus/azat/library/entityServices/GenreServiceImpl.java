package ru.otus.azat.library.entityServices;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional(readOnly = true)
    @Override
    public Genre getGenre(String name){
        try {
            return genreDao.getByName(name);
        }catch (GenreException e){
            throw new GenreException();
        }
    }
    @Transactional(readOnly = true)
    @Override
    public List<Genre> getAllGenres(){
        return genreDao.getAll();
    }
}
