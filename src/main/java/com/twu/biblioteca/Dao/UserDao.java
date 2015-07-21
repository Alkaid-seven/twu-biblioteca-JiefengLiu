package com.twu.biblioteca.Dao;

import com.twu.biblioteca.Modal.User;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义 User 数据结构，CRUD操作。
 */

public class UserDao {

    List<User> users = new ArrayList<User>();

    public UserDao() {
        users.add(new User("001", "Crystal", "crystal@qq.com", "001", "customer"));
        users.add(new User("002", "Jackie", "jackie@qq.com", "002", "customer"));
        users.add(new User("003", "Lisa", "lisa@qq.com", "003", "librarian"));
    }

    public UserDao(User...initusers){
        for(User user: initusers){
            users.add(user);
        }
    }


    public boolean login(String userId, String password){
        for(User user: users){
            if(user.getUserId().equalsIgnoreCase(userId) && user.getPassword().equalsIgnoreCase(password)){
               user.setLogin(true);
               return true;
            }
        }
        return false;
    }

    public List<User> getUsers() {
        return users;
    }

}