package com.caoyang.model;

import java.sql.Date;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String gender;
    private java.util.Date birthDate;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    //constructor
    public User() {
    }

    public User(int id, String username, String password, String email, String gender, java.util.Date birthDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.birthDate = birthDate;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this. password = password;
    }
    public String getEmail() {
        final String email = this.email;
        return email;
    }
    public void setEmail(String email) {

        this.email = email;
    }
    public String getGender() {
        return gender;
    }
    public java.util.Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(java.util.Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setGender(String gender) {
    }

    public void setSex(String sex) {
    }

    public void setBirthday(Date birthday) {
    }

    public void getSex() {
    }

    public void getBirthday() {
    }

    public void setId(String id) {
    }

    public void getrememberMe() {
    }
}












