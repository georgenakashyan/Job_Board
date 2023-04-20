package com.group.job_board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author main
 */
public class Applicant extends ModeratableUser implements Jobs {

    ArrayList<Applicant> applicants = new ArrayList();

    protected String firstName, lastName;

    public Applicant() {
    }

    public Applicant(String firstName, String lastName, String road, String town, String state, String email, String phoneNumber, String password, String username) {
        super(road, town, state, email, phoneNumber, password, username);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // ToDo write code for updateProfile(), deleteProfile(), search(), and apply()
    public void updateProfile() {
    }

    public void deleteProfile() {
    }

    @Override
    public Jobs addJob() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Jobs search() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void apply() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void viewJob() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}