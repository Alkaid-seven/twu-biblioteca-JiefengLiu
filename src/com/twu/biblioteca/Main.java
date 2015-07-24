package com.twu.biblioteca;

import com.twu.biblioteca.Dao.UserDao;
import com.twu.biblioteca.Services.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) throws IOException {
        PrintStream printStream = System.out;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        UserDao userDao = new UserDao();
        UserService userService = new UserService(printStream, reader, userDao);

        Menu menu = new Menu();
        Login login = new Login(userDao, userService);

        login.welcome();
        if(login.isSuccess()) {
            menu.start();}
    }
}