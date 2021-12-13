package ru.otus.azat.reading;

import org.springframework.stereotype.Repository;
import ru.otus.azat.entities.Question;
import org.springframework.beans.factory.annotation.Value;
import ru.otus.azat.exception.QuestionsLoadingException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Repository
public class ReaderCSV implements Reader {
    private String path;

    public ReaderCSV(@Value("${path}") String path) {
        this.path = path;
    }
    //а как сделать IOException unchecked если он checked ?))
    @Override
    public List<Question> readAll(){
        List<Question> quize = new ArrayList<>();
        try{
            InputStream is = getClass().getClassLoader().getResourceAsStream(path);
            InputStreamReader inputStreamReader = new InputStreamReader(is);
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
            is.close();
            inputStreamReader.close();
        } catch (IOException e) {
            //не понял как обернуть это в свое исключение.
            // Компилятор ругался, говорил обязательно IOException надо ловить
            e.printStackTrace();
        }
        return quize;
    }
}
