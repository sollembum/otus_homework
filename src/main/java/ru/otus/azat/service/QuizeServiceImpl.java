package ru.otus.azat.service;

import org.springframework.beans.factory.annotation.Value;
import ru.otus.azat.entities.Question;
import org.springframework.stereotype.Service;
import ru.otus.azat.reading.ReaderCSV;

import java.util.List;
import java.util.Scanner;

@Service
public class QuizeServiceImpl implements QuizeService{
    private final int acceptableLvl;
    private final Interactor consoleInteractor;
    private final ReaderCSV readerCSV;

    public QuizeServiceImpl(Interactor consoleInteractor,ReaderCSV readerCSV, @Value("${acceptable_lvl}") int acceptableLvl) {
        this.acceptableLvl = acceptableLvl;
        this.readerCSV = readerCSV;
        this.consoleInteractor = consoleInteractor;
    }

    @Override
    public void startQuize(){
        List<Question> listOfQuestions = readerCSV.readAll();
        int rightAnswers = 0;
        for (Question qa: listOfQuestions) {
            consoleInteractor.out(qa.getQuestion() + System.lineSeparator() + "Input the answer: ");
            String answer = consoleInteractor.readLine();
            if (answer.equals(qa.getRightAnswer().trim())){
                rightAnswers++;
            }
        }
        showResult(rightAnswers);
    }
    private void showResult (int rightAnswers){
        if (rightAnswers >= acceptableLvl){
            System.out.println("You gave "+rightAnswers + " right answers. You passed the test");
        } else {
            System.out.println("You gave "+rightAnswers + " right answers. You failed the test");
        }
    }
}
