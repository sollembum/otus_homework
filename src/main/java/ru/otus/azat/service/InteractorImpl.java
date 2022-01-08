package ru.otus.azat.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

@Service
public class InteractorImpl implements Interactor {


    private final Scanner consoleIn;
    private final PrintStream consoleOut;

    public InteractorImpl(@Value("#{ T (java.lang.System).in}") InputStream in,
                          @Value("#{ T(java.lang.System).out}") PrintStream out) {
        this.consoleIn = new Scanner(in);
        this.consoleOut = out;
    }

    @Override
    public void out(String message) {
        consoleOut.println(message);
    }

    @Override
    public String readLine() {
        return consoleIn.nextLine();
    }
}
