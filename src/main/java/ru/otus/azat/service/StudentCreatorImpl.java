package ru.otus.azat.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.azat.entities.Student;
import java.util.Locale;

@Service
public class StudentCreatorImpl implements StudentCreator {
    private final Interactor interactor;
    private final MessageSource msg;

    public StudentCreatorImpl(Interactor interactor, MessageSource msg) {
        this.interactor = interactor;
        this.msg = msg;
    }

    @Override
    public Student createStudent(String localizationCode) {
        Student student = new Student();
        if (localizationCode.equals("ru")) {
            interactor.out(
                    msg.getMessage("strings.askName",
                            new String[] {},
                            Locale.forLanguageTag("ru-RU"))
            );
            student.setName(interactor.readLine());
            interactor.out(
                    msg.getMessage("strings.askSurname",
                            new String[] {},
                            Locale.forLanguageTag("ru-RU"))
            );
            student.setSurname(interactor.readLine());
        }
        return student;
    }
}
