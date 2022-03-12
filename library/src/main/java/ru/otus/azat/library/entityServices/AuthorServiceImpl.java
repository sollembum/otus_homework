package ru.otus.azat.library.entityServices;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional(readOnly = true)
    @Override
    public Author getAuthor(String fullname){
        try {
            return authorDao.getByName(fullname);
        }catch (AuthorException e){
            throw new AuthorException();
        }
    }
    @Transactional(readOnly = true)
    @Override
    public List<Author> getAllAuthors(){
        return authorDao.getAll();
    }
}
