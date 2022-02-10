package ru.otus.azat.quizing.service;

import org.springframework.stereotype.Service;
import ru.otus.azat.quizing.entities.Student;

@Service
public class StudentCreatorImpl implements StudentCreator {
    private final Interactor interactor;
    private final LocalizationService localizationService;

    public StudentCreatorImpl(Interactor interactor, LocalizationService localizationService) {
        this.interactor = interactor;
        this.localizationService = localizationService;
    }

    @Override
    public Student createStudent() {
        Student student = new Student();
        interactor.out(localizationService.getLocalMessage("strings.askName"));
        student.setName(interactor.readLine());
        interactor.out(localizationService.getLocalMessage("strings.askSurname"));
        student.setSurname(interactor.readLine());
        return student;
    }
}
