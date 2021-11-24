package service;

import entities.QuestionAnswer;
import reading.ReaderCSV;

import java.util.ArrayList;
import java.util.List;

public class QuizeService {
    private final ReaderCSV readerCSV;

    public QuizeService(ReaderCSV readerCSV) {
        this.readerCSV = readerCSV;
    }
    public String showQuestions(){
        List<String> listOfQuestions = new ArrayList<>();
        for (QuestionAnswer quizeElement :readerCSV.read()) {
            listOfQuestions.add(quizeElement.getQuestion());
        }
        return listOfQuestions.toString();
    }
}
