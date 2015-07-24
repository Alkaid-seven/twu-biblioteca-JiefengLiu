package com.twu.biblioteca.Services;

import com.twu.biblioteca.Dao.UserDao;
import com.twu.biblioteca.Modal.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 用户登录，用户信息展示。
 */

public class UserService {
    private UserDao userDao;
    private PrintStream printStream;
    private BufferedReader reader;
    private boolean islogin = false;
    private String fmt = "%1$-20s %2$-20s %3$20s%n";

    public UserService(PrintStream printStream, BufferedReader reader, UserDao userDao) {
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

    private void printHeader(PrintStream printStream) {
        printStream.format(fmt, "User Name", "Email Address", "Phone Number");
        printStream.format(fmt, "---------", "-------------", "------------");
    }

    public void getInfo(PrintStream printStream){
        User user = userDao.getInfo();
        if (user != null){
            printHeader(printStream);
            printStream.format(fmt, user.getName(), user.getEmail(), user.getPhone());
        }else{
            printStream.println("You have no access to see the information!");
        }
    }

}