package com.twu.biblioteca;

import com.twu.biblioteca.Controller.CheckoutBookCommand;
import com.twu.biblioteca.Controller.Command;
import com.twu.biblioteca.Controller.ListBooksCommand;
import com.twu.biblioteca.Controller.ReturnBooksCommand;
import com.twu.biblioteca.Dao.BookDao;
import com.twu.biblioteca.Services.BookService;
import com.twu.biblioteca.Services.LoginService;

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

    private boolean cango = true;

    public Menu(){
        commandMap.put("1", new ListBooksCommand(printStream, bookService));
        commandMap.put("2", new CheckoutBookCommand(printStream, bufferedReader, bookService));
        commandMap.put("3", new ReturnBooksCommand(printStream, bufferedReader, bookService));
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
