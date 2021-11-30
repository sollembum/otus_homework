package ru.otus.azat.reading;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.otus.azat.entities.QuestionAnswer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@Repository
public class ReaderCSV implements Reader {
    private String path;

    public ReaderCSV(@Value("${path}") String path) {
        this.path = path;
    }

    public List<QuestionAnswer> read(){
        List<QuestionAnswer> quize = new ArrayList<>();
        try{
            File file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource(path)).getFile());
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            Scanner scanner;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                QuestionAnswer qa = new QuestionAnswer();
                scanner = new Scanner(line);
                scanner.useDelimiter(",");
                while (scanner.hasNext()){
                    String data = scanner.next();
                    if (index%2==0){
                        qa.setQuestion(data);
                    }else qa.setAnswer(data);
                    index++;
                }
                quize.add(qa);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return quize;
    }
}
