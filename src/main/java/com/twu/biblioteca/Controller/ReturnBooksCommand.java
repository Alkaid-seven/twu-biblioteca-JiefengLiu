package com.twu.biblioteca.Controller;

import com.twu.biblioteca.Services.BookService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;


public class ReturnBooksCommand implements Command {
    private final PrintStream printStream;
    private final BufferedReader bufferedReader;
    private final BookService bookService;

    public ReturnBooksCommand(PrintStream printStream, BufferedReader bufferedReader, BookService bookService) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.bookService = bookService;
    }

    public void execute() throws IOException {

        printStream.println("Return the book by input the bookId.");
        printStream.println();
        bookService.listChecked(printStream);

        String bookId= bufferedReader.readLine();
        Boolean isReturn = bookService.returnBook(bookId);

        if (isReturn) {
            printStream.println("Thank you for returning the book.");
        } else {
            printStream.println("That is not a valid book to return.");
        }
    }

    public String description() {
        return "Return Book";
    }
}