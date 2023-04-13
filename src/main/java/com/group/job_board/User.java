/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.group.job_board;

/**
 *
 * @author George / Tim
 */
public abstract class User {

    //ToDo 1: make member variables
    protected int userID;
    protected long phone;
    protected String username, password, email;
    protected boolean active;

    //ToDo 2: make constructors
    public User() {
        this.userID = 0;
        this.phone = 0;
        this.username = "";
        this.password = "";
        this.email = "";
        this.active = false;
    }

    public User(int userID, String username, String password, long phone, String email, boolean active) {
        this.userID = userID;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.email = email;
        this.active = active;
    }

    //ToDo 3: make getters and setters
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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
        this.password = password;
    }

}
