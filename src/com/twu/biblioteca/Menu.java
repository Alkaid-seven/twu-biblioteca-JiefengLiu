package com.twu.biblioteca;

import com.twu.biblioteca.Controller.*;
import com.twu.biblioteca.Dao.BookDao;
import com.twu.biblioteca.Dao.FilmDao;
import com.twu.biblioteca.Dao.UserDao;
import com.twu.biblioteca.Services.BookService;
import com.twu.biblioteca.Services.FilmService;
import com.twu.biblioteca.Services.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 菜单选项。
 * 1.……
 * 2.……
 */

public class Menu {

    private Map<String, Command> commandMap = new HashMap();

    private PrintStream printStream = System.out;
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private BookDao bookDao = new BookDao();
    private BookService bookService = new BookService(bookDao);
    private FilmDao filmDao = new FilmDao();
    private FilmService filmService= new FilmService(filmDao);
    private UserDao userDao = new UserDao();
    private UserService userService = new UserService(printStream, bufferedReader, userDao);

    private boolean cango = true;

    public Menu(){
        commandMap.put("1", new ListBooksCommand(printStream, bookService));
        commandMap.put("2", new CheckoutBookCommand(printStream, bufferedReader, bookService));
        commandMap.put("3", new ReturnBooksCommand(printStream, bufferedReader, bookService));
        commandMap.put("4", new ListFilmsCommand(printStream, filmService));
        commandMap.put("5", new CheckoutFilmCommand(printStream, bufferedReader, filmService));
        commandMap.put("6", new UserInfoCommand(printStream, userService));
    }

    public void start() throws IOException {
        do{
            printOptions();
            select();
        }while(cango);
    }

    private void printOptions() throws IOException {
        printStream.println();
        printStream.println("Please select your option:");

        for (String index : commandMap.keySet()) {
            printStream.println(index + ". " + commandMap.get(index).description());
        }
        printStream.println("Q. Quit");
        printStream.println();
    }

    private void select() throws IOException {

        String input = bufferedReader.readLine();

        if (input.equalsIgnoreCase("q")) {
            cango = false;
            return;
        }

        if (commandMap.containsKey(input)) {
            commandMap.get(input).execute();
        } else {
            printStream.println("Select a valid option!");
        }
    }
}