package ru.otus.azat.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.azat.entities.Student;
import java.util.Locale;

@Service
public class StudentCreatorImpl implements StudentCreator {
    private final Interactor interactor;
    private final LocalizationService localizationService;

    public StudentCreatorImpl(Interactor interactor, LocalizationService localizationService) {
        this.interactor = interactor;
        this.localizationService = localizationService;
    }

    @Override
    public Student createStudent(String localizationCode) {
        Student student = new Student();
        interactor.out(localizationService.getLocalMessage("strings.askName"));
        student.setName(interactor.readLine());
        interactor.out(localizationService.getLocalMessage("strings.askSurname"));
        student.setSurname(interactor.readLine());
        return student;
    }
}
