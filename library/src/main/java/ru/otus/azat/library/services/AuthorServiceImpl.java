package ru.otus.azat.library.services;

import org.springframework.stereotype.Service;
import ru.otus.azat.library.repositories.AuthorRepository;
import ru.otus.azat.library.entities.Author;
import ru.otus.azat.library.exceptions.AuthorException;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{
    private final AuthorRepository authorDao;

    public AuthorServiceImpl(AuthorRepository authorDao) {
        this.authorDao = authorDao;
    }
    @Override
    public Author getAuthor(String fullname){
        try {
            return authorDao.getByName(fullname);
        }catch (AuthorException e){
            throw new AuthorException();
        }
    }
    @Override
    public List<Author> getAllAuthors(){
        return authorDao.getAll();
    }
}
