package com.twu.biblioteca.Modal;

/**
 * Created by songyang on 10/5/14.
 */
public class User {
    private String name;
    private String userId;
    private String email;
    private String password;
    private String role;
    private boolean isLogin = false;

    public User(String userId, String name, String email, String password, String role) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role= role;
    }

    public String getUserId() {
        return userId;
    }

    public void setuserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPrivilege(String role){
        this.role = role;
    }

    public String getPrivilege(){
        return role;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }
}