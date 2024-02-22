package org.example.models;

public class User {
    private int userId;

    private String firstName;
    private String secondName;
    private int age;
    private Gender gender;
    private String userName;
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public String getUserName() {
        return userName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public User setSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public User setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public int getUserId() {
        return userId;
    }
}
