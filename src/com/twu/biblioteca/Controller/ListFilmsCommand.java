package com.twu.biblioteca.Controller;

import com.twu.biblioteca.Services.FilmService;
import java.io.IOException;
import java.io.PrintStream;

public class ListFilmsCommand implements Command {

    private final FilmService filmService;
    private final PrintStream printStream;

    public ListFilmsCommand(PrintStream printStream, FilmService filmService) {
        this.printStream = printStream;
        this.filmService = filmService;
    }

    public void execute() throws IOException {
        filmService.list(printStream);
    }

    public String description(){
        return "List Films";
    }
}