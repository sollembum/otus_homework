package ru.otus.azat.service;

//не понятно насколько общим следует сделать этот интерфейс
//то есть он должен быть только для вопросов и ответов
//а от реализации зависит то, где и как он общается с юзером

public interface Interactor {
    void askQuestion(String info);
    String readAnswer();
}
