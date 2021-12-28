package ru.otus.azat.service;

import org.springframework.stereotype.Service;
import ru.otus.azat.entities.Student;

@Service
public class StudentCreatorImpl implements StudentCreator {
    private final Interactor interactor;

    public StudentCreatorImpl(Interactor interactor) {
        this.interactor = interactor;
    }

    @Override
    public Student createStudent() {
        Student student = new Student();
        interactor.out("Enter your name: ");
        student.setName(interactor.readLine());
        interactor.out("Enter your surname: ");
        student.setSurname(interactor.readLine());
        return student;
    }
}
