package com.twu.biblioteca.Controller;

import com.twu.biblioteca.Services.UserService;

import java.io.IOException;
import java.io.PrintStream;


public class UserInfoCommand implements Command {

    private final UserService userService;
    private final PrintStream printStream;

    public UserInfoCommand(PrintStream printStream, UserService userService) {
        this.printStream = printStream;
        this.userService = userService;
    }

    public void execute() throws IOException {
        userService.getInfo(printStream);
    }

    public String description(){
        return "User Info";
    }
}