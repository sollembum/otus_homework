package ru.otus.azat.service;

import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

@Service
public class ConsoleInteractor implements Interactor {

    //не понимаю немного зачем System.in и System.out класть в конструктор
    //поэтому не понимаю, как это должно было выглядеть

    private final InputStream consoleIn;
    private final PrintStream consoleOut;

    public ConsoleInteractor() {
        this.consoleIn = System.in;
        this.consoleOut = System.out;
    }

    @Override
    public void askQuestion(String question) {
        consoleOut.println(question);
        consoleOut.print("Input the answer: ");
    }

    @Override
    public String readAnswer() {
        Scanner scanner = new Scanner(consoleIn);
        return scanner.nextLine();
    }
}
