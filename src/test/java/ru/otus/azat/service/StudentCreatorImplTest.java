package ru.otus.azat.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.otus.azat.entities.Student;
import ru.otus.azat.holders.LocaleHolder;
import ru.otus.azat.service.Interactor;
import ru.otus.azat.service.StudentCreator;

import java.util.spi.LocaleServiceProvider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
public class StudentCreatorImplTest {
    @Autowired
    private StudentCreator studentCreator;

    @MockBean
    private LocalizationService localizationService;
    @MockBean
    private Interactor interactor;

    @Test
    public void createStudentSuccessTest(){
        when(localizationService.getLocalMessage("messageCode")).thenReturn("mockMessage");
        when(interactor.readLine()).thenReturn("1and2");
        Student student = studentCreator.createStudent();
        assertNotNull(student);
        assertEquals(student.getName(), "1and2");
        assertEquals(student.getSurname(), "1and2");
    }
}
