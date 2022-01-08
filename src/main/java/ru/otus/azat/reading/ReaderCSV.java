package ru.otus.azat.reading;

import org.springframework.stereotype.Repository;
import ru.otus.azat.entities.Question;
import ru.otus.azat.exception.QuestionsLoadingException;
import ru.otus.azat.service.LocalizationService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Repository
public class ReaderCSV implements Reader {
    private String path;
    private final LocalizationService localizationService;
    public ReaderCSV(LocalizationService localizationService) {
        this.localizationService = localizationService;
    }
    private void setPath(){
        this.path = "quize-" + localizationService.getCurrentLocalization() + ".csv";
    }
    @Override
    public List<Question> readAll(){
        setPath();
        List<Question> quize = new ArrayList<>();
        try(InputStream is = getClass().getClassLoader().getResourceAsStream(path);
            InputStreamReader inputStreamReader = new InputStreamReader(is)){
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line;
            Scanner scanner;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                Question qa = new Question();
                scanner = new Scanner(line);
                scanner.useDelimiter(",");
                while (scanner.hasNext()){
                    String data = scanner.next();
                    if (index%2==0){
                        qa.setQuestion(data);
                    }else qa.setRightAnswer(data);
                    index++;
                }
                quize.add(qa);
            }
        } catch (Exception e) {
            throw new QuestionsLoadingException("Exception during loading questions", e);
        }
        return quize;
    }
}
