package ru.otus.azat.quizing.reading;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.otus.azat.quizing.entities.Question;
import ru.otus.azat.quizing.exception.QuestionsLoadingException;
import ru.otus.azat.quizing.holders.LocaleHolder;

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
