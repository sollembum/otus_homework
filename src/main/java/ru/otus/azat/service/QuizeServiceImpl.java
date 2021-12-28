package ru.otus.azat.service;

import org.springframework.beans.factory.annotation.Value;
import ru.otus.azat.entities.Question;
import org.springframework.stereotype.Service;
import ru.otus.azat.entities.Student;
import ru.otus.azat.reading.Reader;

import java.util.List;

@Service
public class QuizeServiceImpl implements QuizeService{
    private final int acceptableLvl;
    private final Interactor interactor;
    private final Reader readerCSV;
    private final StudentCreator studentCreator;

    public QuizeServiceImpl(Interactor interactor, Reader readerCSV, @Value("${acceptable_lvl}") int acceptableLvl, StudentCreator studentCreator) {
        this.acceptableLvl = acceptableLvl;
        this.readerCSV = readerCSV;
        this.interactor = interactor;
        this.studentCreator = studentCreator;
    }

    @Override
    public void startQuize(){
        Student student = studentCreator.createStudent();
        List<Question> listOfQuestions = readerCSV.readAll();
        for (Question qa: listOfQuestions) {
            interactor.out(qa.getQuestion() + System.lineSeparator() + "Input the answer: ");
            String answer = interactor.readLine();
            if (answer.equals(qa.getRightAnswer().trim())){
                student.thatWasRightAnswer();
            }
        }
        showResult(student.getRightAnswers());
    }
    private void showResult (int rightAnswers){
        if (rightAnswers >= acceptableLvl){
            System.out.println("You gave "+rightAnswers + " right answers. You passed the test");
        } else {
            System.out.println("You gave "+rightAnswers + " right answers. You failed the test");
        }
    }
}
