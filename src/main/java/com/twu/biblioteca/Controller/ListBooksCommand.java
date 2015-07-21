package com.twu.biblioteca.Controller;

import com.twu.biblioteca.Services.BookService;

import java.io.IOException;
import java.io.PrintStream;


public class ListBooksCommand implements Command {

    private final BookService bookService;
    private final PrintStream printStream;

    public ListBooksCommand(PrintStream printStream, BookService bookService) {
        this.printStream = printStream;
        this.bookService = bookService;
    }

    public void execute() throws IOException {
        bookService.list(printStream);
    }

    public String description() {
        return "List books";
    }
}