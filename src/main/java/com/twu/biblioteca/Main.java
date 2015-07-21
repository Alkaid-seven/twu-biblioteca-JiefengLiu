package com.twu.biblioteca;

import com.twu.biblioteca.Controller.CheckoutBookCommand;
import com.twu.biblioteca.Controller.Command;
import com.twu.biblioteca.Controller.ListBooksCommand;
import com.twu.biblioteca.Controller.ReturnBooksCommand;
import com.twu.biblioteca.Dao.BookDao;
import com.twu.biblioteca.Dao.UserDao;
import com.twu.biblioteca.Services.BookService;
import com.twu.biblioteca.Services.LoginService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        PrintStream printStream = System.out;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        UserDao userDao = new UserDao();
        LoginService loginService = new LoginService(printStream, reader, userDao);

        Menu menu = new Menu();
        Login login = new Login(userDao, loginService);

        login.welcome();
        if(login.isSuccess()) {
            menu.start();}
    }
}