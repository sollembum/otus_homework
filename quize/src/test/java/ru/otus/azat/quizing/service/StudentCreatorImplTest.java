package ru.otus.azat.quizing.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.otus.azat.quizing.entities.Student;
import ru.otus.azat.quizing.service.Interactor;
import ru.otus.azat.quizing.service.LocalizationService;
import ru.otus.azat.quizing.service.StudentCreator;

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
