package com.twu.biblioteca.Controller;

import com.twu.biblioteca.Services.BookService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;


public class CheckoutBookCommand implements Command {

    private final PrintStream printStream;
    private final BufferedReader bufferedReader;
    private final BookService bookService;

    public CheckoutBookCommand(PrintStream printStream, BufferedReader bufferedReader, BookService bookService) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.bookService = bookService;
    }

    public void execute() throws IOException {

        printStream.println("Check out book by input the bookId.");
        String input = bufferedReader.readLine();
        boolean ischecked = bookService.checkout(input);

        if (ischecked) {
            printStream.println("Thank you! Enjoy the book");
        } else {
            printStream.println("That book is not available.");
        }
    }

    public String description() {
        return "Check out book";
    }
}