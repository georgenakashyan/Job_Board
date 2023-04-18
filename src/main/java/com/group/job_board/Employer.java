/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.job_board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author main
 */
public class Employer extends ModeratableUser implements Jobs {

    // Employer variables
    String companyName;

    // constructor
    public Employer() {
    }

    public Employer(int userID, String companyName, String address, String username, String email, long phoneNumber, String password) {
        super(userID, email, phoneNumber, address, password, username);
        this.companyName = companyName;
        this.active = true;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public void loadUsers() {
        //create the variables for each field in the file
        ArrayList<Employer> employers = new ArrayList();
        int id = 0;
        String employerName = "";
        String employerAddress = "";
        String recruiterName = "";
        String recruiterEmail = "";
        int recruiterPhone = 0;
        String password = "";
        boolean active = false;
        int totalrows = 0, index = 0;

        connectDB();

        try {
            //Get the total rows in the table to loop through the result set
            resultSet = statement.executeQuery("SELECT * FROM employer");
            //resultSet.first();

            totalrows = resultSet.getRow();
            while (resultSet.next()) //tests for the eof
            {
                totalrows = resultSet.getRow();
                id = resultSet.getInt("ID");
                employerName = resultSet.getString("employerName");
                employerAddress = resultSet.getString("employerAddress");
                recruiterName = resultSet.getString("recruiterName");
                recruiterEmail = resultSet.getString("recruiterEmail");
                recruiterPhone = resultSet.getInt("recruiterPhone");
                password = resultSet.getString("password");
                active = resultSet.getBoolean("active");
                Employer e = new Employer();
                employers.add(e);
                index++;

            }
            System.out.println(employers.get(0).toString());
        } catch (SQLException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    // ToDo write code for addPosition() and viewPosition()
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

    @Override
    public String toString() {
        // int userID, String companyName, String address, String recruiterName, String email, int phoneNumber, String password, boolean active
        return "Employer{" + "user ID: " + userID + ", company name: " + companyName
                + ", address:" + address + ", recruiter name: " + username + ", recruiter email: " + email + ", "
                + ", phone number: " + phoneNumber + ", password: " + password + '}';
    }

}
