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
    private final ConsoleInteractor consoleInteractor;
    private final ReaderCSV readerCSV;

    public QuizeServiceImpl(ConsoleInteractor consoleInteractor,ReaderCSV readerCSV, @Value("${acceptable_lvl}") int acceptableLvl) {
        this.acceptableLvl = acceptableLvl;
        this.readerCSV = readerCSV;
        this.consoleInteractor = consoleInteractor;
    }

    @Override
    public void startQuize(){
        List<Question> listOfQuestions = readerCSV.readAll();
        int rightAnswers = 0;
        for (Question qa: listOfQuestions) {
            consoleInteractor.askQuestion(qa.getQuestion());
            String answer = consoleInteractor.readAnswer();
            if (answer.equals(qa.getRightAnswer().trim())){
                rightAnswers++;
            }
        }
        //в consoleInteractor нет смысла переносить кусок ниже, так как логично, что Quize говорит о рез-ах теста
        if (rightAnswers >= acceptableLvl){
            System.out.println("You gave "+rightAnswers + " right answers. You passed test");
        } else {
            System.out.println("You gave "+rightAnswers + " right answers. You failed test");
        }
    }
}
