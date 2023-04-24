/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.job_board;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author main
 */
public class Moderator extends Users {

    String firstName, lastName;

    public Moderator() {
    }

    public Moderator(String firstName, String lastName, String email, String phoneNumber, String password, String username) {
        super(email, phoneNumber, password, username);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addModerator(String firstName, String lastName, String email, String phoneNumber, String password, String username) {

    }

    public void removeModerator(int userID) {
    }

    public void removeApplicant(int userID) {
    }

    public void removeEmployer(int userID) {
    }

    private void viewJobs() {
    }

    public void login() {
    }

    public void logout() {
    }
}
