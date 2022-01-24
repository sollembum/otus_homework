package ru.otus.azat.entities;

public class Result {
    private Student student;
    private int rightAnswers;

    public void wasRightAnswer(){
        rightAnswers++;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getRightAnswers() {
        return rightAnswers;
    }

    public void setRightAnswers(int rightAnswers) {
        this.rightAnswers = rightAnswers;
    }
}
