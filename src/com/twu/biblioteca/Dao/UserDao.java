package com.twu.biblioteca.Dao;

import com.twu.biblioteca.Modal.User;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义 User 数据结构，CRUD操作。
 */

public class UserDao {

    List<User> users = new ArrayList<User>();
    private static User nowUser;

    public UserDao() {
        users.add(new User("001-1234", "Crystal", "crystal@qq.com", "13544488832", "001", "customer"));
        users.add(new User("002-1234", "Jackie", "jackie@qq.com", "002", "13100002222", "customer"));
        users.add(new User("003-1234", "Lisa", "lisa@qq.com", "003","18800003333", "librarian"));
    }

    public UserDao(User...initusers){
        for(User user: initusers){
            users.add(user);
        }
    }


    public boolean login(String userId, String password){
        nowUser = null; // 保证是当前用户的信息。
        for(User user: users){
            if(user.getUserId().equalsIgnoreCase(userId) && user.getPassword().equalsIgnoreCase(password)){
                nowUser = user;
                user.setLogin(true);
                return true;
            }
        }
        return false;
    }

    public User getInfo(){
        if(nowUser != null){
            return nowUser;
        }else{
            return null;
        }
    }

    public List<User> getUsers() {
        return users;
    }

}