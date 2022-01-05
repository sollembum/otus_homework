package ru.otus.azat.service;

import ru.otus.azat.config.QuizeConfig;
import ru.otus.azat.entities.Question;
import org.springframework.stereotype.Service;
import ru.otus.azat.entities.Result;
import ru.otus.azat.reading.Reader;

import java.util.List;

@Service
public class QuizeServiceImpl implements QuizeService{

    private final int acceptableLvl;
    private final Interactor interactor;
    private final Reader reader;
    private final StudentCreator studentCreator;

    public QuizeServiceImpl(Interactor interactor, Reader reader, QuizeConfig config, StudentCreator studentCreator) {
        this.acceptableLvl = config.getAcceptableLvl();
        this.reader = reader;
        this.interactor = interactor;
        this.studentCreator = studentCreator;
    }

    @Override
    public void startQuize(){
        interactor.out("Enter your localization:");
        //хорошее ли решение сделать локальную переменную из локализации теста?
        String localizationCode = interactor.readLine();
        Result result = new Result();
        //нормально ли передавать ее во все сервисы?
        result.setStudent(studentCreator.createStudent(localizationCode));
        List<Question> listOfQuestions = reader.readAll();
        for (Question qa: listOfQuestions) {
            interactor.out(qa.getQuestion() + System.lineSeparator() + "Input the answer: ");
            String answer = interactor.readLine();
            if (answer.equals(qa.getRightAnswer().trim())){
                result.wasRightAnswer();
            }
        }
        showResult(result.getRightAnswers());
    }
    private void showResult (int rightAnswers){
        if (rightAnswers >= acceptableLvl){
            System.out.println("You gave "+rightAnswers + " right answers. You passed the test");
        } else {
            System.out.println("You gave "+rightAnswers + " right answers. You failed the test");
        }
    }
}
