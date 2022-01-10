package ru.otus.azat.service;

import ru.otus.azat.holders.LocaleHolder;
import ru.otus.azat.holders.LocaleHolderImpl;
import ru.otus.azat.config.QuizeConfig;
import ru.otus.azat.entities.Question;
import org.springframework.stereotype.Service;
import ru.otus.azat.entities.Result;
import ru.otus.azat.reading.Reader;

import java.util.Arrays;
import java.util.List;

@Service
public class QuizeServiceImpl implements QuizeService{
    private final LocaleHolder localeHolder;
    private final LocalizationService localizationService;
    private final String[] languages;
    private final int acceptableLvl;
    private final Interactor interactor;
    private final Reader reader;
    private final StudentCreator studentCreator;

    public QuizeServiceImpl(LocaleHolder localeHolder, LocalizationService localizationService, Interactor interactor,
                            Reader reader, QuizeConfig config, StudentCreator studentCreator) {
        this.localeHolder = localeHolder;
        this.localizationService = localizationService;
        this.languages = config.getLanguages();
        this.acceptableLvl = config.getAcceptableLvl();
        this.reader = reader;
        this.interactor = interactor;
        this.studentCreator = studentCreator;
    }

    @Override
    public void startQuize(){
        interactor.out("Choose your localization " + Arrays.toString(languages));
        String localizationCode = interactor.readLine();
        localeHolder.changeLocalization(localizationCode);
        Result result = new Result();
        result.setStudent(studentCreator.createStudent());
        List<Question> listOfQuestions = reader.readAll();
        for (Question qa: listOfQuestions) {
            interactor.out(qa.getQuestion() + System.lineSeparator() +
                    localizationService.getLocalMessage("strings.askForAnswer"));
            String answer = interactor.readLine();
            if (answer.equals(qa.getRightAnswer().trim())){
                result.wasRightAnswer();
            }
        }
        showResult(result.getRightAnswers());
    }
    private void showResult (int rightAnswers){
        if (rightAnswers >= acceptableLvl){
            interactor.out(localizationService.getLocalMessage("strings.announceSuccess"));
        } else {
            interactor.out(localizationService.getLocalMessage("strings.announceFail"));
        }
    }
}
