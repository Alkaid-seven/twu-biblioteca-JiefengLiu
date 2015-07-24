package com.twu.biblioteca;

import com.twu.biblioteca.Dao.UserDao;
import com.twu.biblioteca.Services.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;


public class Login {

    private UserDao userDao;
    private UserService userService;
    private PrintStream printStream = System.out;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Login(UserDao userDao, UserService userService){
        this.userDao = userDao;
        this.userService = userService;
    }

    public void welcome(){
        printStream.println("Welcome to biblioteca!");
    }

    public boolean isSuccess() throws IOException{

        if(userService.auth()){
            return true;
        }else{
            printStream.println("User Id: ");
            String userId = reader.readLine();
            printStream.println("Password: ");
            String password = reader.readLine();
            if(userService.isLogin(userId, password)){
                return true;
            }else{
                return isSuccess();
            }
        }
    }

    public void failed(){
        System.out.println("Goodbye!");
    }
}