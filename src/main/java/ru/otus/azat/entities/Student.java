package ru.otus.azat.entities;

public class Student {
    private String name;
    private String surname;
    private int rightAnswers = 0;

    public int getRightAnswers() {
        return rightAnswers;
    }

    public void thatWasRightAnswer(){
        rightAnswers++;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
