/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.job_board;

/**
 *
 * @author main
 */
public class Moderator extends User {
    String firstName;
    String lastName;
    public Moderator() {
    }

    public Moderator(String firstName, String lastName, int userID, String username, String password, int phone, String email, boolean active) {
        super(userID, username, password, phone, email, active);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    
    // method prototypes
    public void login() {
    }

    public void logout() {
    }

    private static void viewJobs() {
    }

    private static void approveJobs() {
    }

    public static void removeUser() {
    }

}
