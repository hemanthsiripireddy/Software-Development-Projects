package com.hemanth.request;

import com.hemanth.model.User;

public class UserRequest {
    private int id;
    private String userName;
    private String password;
    private String mail;
    private String name;
    public UserRequest(String userName,String password){
        this.userName=userName;
        this.password=password;
    }
    public User getUser(){
        User user=new User();

        user.setUserName(userName);
        user.setPassword(password);
        if(mail!=null){
            user.setMail(mail);
        }
        if(name!=null){
            user.setName(name);
        }
        return user;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
