/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.group.job_board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

/**
 *
 * @author George / Tim
 */
public abstract class User {

    //ToDo 1: make member variables
    protected int userID;
    protected long phoneNumber;
    protected String email, password;
    protected boolean active;
    protected String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    //for connecting to database
    Connection connection = null;
    Statement statement;
    ResultSet resultSet;

    //ToDo 2: make constructors
    public User() {
        this.userID = 0;
        this.email = "";
        this.phoneNumber = 0;
        this.password = "";
        this.active = false;
    }

    public User(int userID, String email, long phoneNumber, String password, String username) {
        this.userID = userID;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.username = username;
        this.email = email;
    }

    //ToDo 3: make getters and setters
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void connectDB() {
        try {
            // Database variables
            // Step 1: Loading or registering JDBC driver class 
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            // Step 2: Opening database connection
            String msAccDB = "codeangels.accdb";
            String dbURL = "jdbc:ucanaccess://" + msAccDB;
            // Step 3: Create and get connection using DriverManager class
            connection = DriverManager.getConnection(dbURL);
            // Step 4: Creating JDBC Statement 
            // It is scrollable so we can use next() and last() & It is updatable so we can enter new records
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            System.out.println("Database Connected!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

    }

    public void loadUsers(){
        
    }
}
