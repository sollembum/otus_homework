package ru.otus.azat.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.azat.service.QuizeService;

@ShellComponent
public class Commands {
    private final QuizeService quizeService;

    public Commands(QuizeService quizeService) {
        this.quizeService = quizeService;
    }
    @ShellMethod(value = "Starts Quize", key = {"start", "startQuize"})
    public String startQuize (){
        return quizeService.startQuize();
    }
}
