package ru.otus.azat.service;

import org.springframework.beans.factory.annotation.Value;
import ru.otus.azat.entities.QuestionAnswer;
import org.springframework.stereotype.Service;
import ru.otus.azat.reading.ReaderCSV;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class QuizeService {
    private final int acceptable_lvl;
    private final ReaderCSV readerCSV;
    private List<QuestionAnswer> listOfQuestionsAnswers;
    public QuizeService(ReaderCSV readerCSV, @Value("${acceptable_lvl}") int acceptable_lvl) {
        this.acceptable_lvl = acceptable_lvl;
        this.readerCSV = readerCSV;
        listOfQuestionsAnswers = readerCSV.read();
    }
    public void startQuize(){
        int rightAnswers = 0;
        Scanner scanner = new Scanner(System.in);
        for (QuestionAnswer qa: listOfQuestionsAnswers) {
            System.out.println(qa.getQuestion());
            System.out.print("Input the answer: ");
            String answer = scanner.nextLine();
            if (answer.equals(qa.getAnswer().trim())){
                rightAnswers++;
            }
        }
        if (rightAnswers >= acceptable_lvl){
            System.out.println("You passed test");
        } else System.out.println("You failed test");
    }
}
