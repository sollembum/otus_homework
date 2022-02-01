package ru.otus.azat.reading;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;
import ru.otus.azat.entities.Question;
import ru.otus.azat.exception.QuestionsLoadingException;
import ru.otus.azat.holders.LocaleHolder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ReadingCSVTest {
    @Autowired
    private Reader reader;

    @MockBean
    private LocaleHolder lh;

    @Test
    public void readAllSuccess(){
        when(lh.getLocaleTag()).thenReturn("en-US");
        List<Question> qa = reader.readAll();
        assertNotNull(qa);
        assertEquals(5, qa.size());
    }
    @Test
    public void readAllFail(){
        assertThrows(QuestionsLoadingException.class, ()-> {
            reader.readAll();
        });
    }
}
