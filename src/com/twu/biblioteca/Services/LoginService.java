package com.twu.biblioteca.Services;

import com.twu.biblioteca.Dao.UserDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 用户登录。
 */
public class LoginService {
    private UserDao userDao;
    private PrintStream printStream;
    private BufferedReader reader;
    private boolean islogin = false;

    public LoginService(PrintStream printStream, BufferedReader reader, UserDao userDao) {
        this.printStream = printStream;
        this.reader = reader;
        this.userDao = userDao;
    }

    public boolean isLogin(String userId, String password) throws IOException {

        if(userDao.login(userId, password)){
            islogin = true;
            printStream.println("Login success!");
            return true;
        } else {
            printStream.println("Login failed. Please try again!");
            return false;
        }
    }

    public boolean auth() {
        if (islogin){
            return true;
        } else {
            printStream.println("Please login first");
            return false;
        }

    }
}