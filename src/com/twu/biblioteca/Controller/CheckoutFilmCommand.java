package com.twu.biblioteca.Controller;

import com.twu.biblioteca.Services.FilmService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 */
public class CheckoutFilmCommand implements Command{

    private final PrintStream printStream;
    private final BufferedReader bufferedReader;
    private final FilmService filmService;

    public CheckoutFilmCommand(PrintStream printStream, BufferedReader bufferedReader, FilmService filmService) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.filmService = filmService;
    }



    public void execute() throws IOException {

        printStream.println("Check out movie by input the movieId.");
        String input = bufferedReader.readLine();
        boolean ischecked = filmService.checkout(input);

        if (ischecked) {
            printStream.println("Thank you! Enjoy the moive!");
        } else {
            printStream.println("That movie is not available.");
        }
    }

    public String description() {
        return "Check out movie";
    }
}
