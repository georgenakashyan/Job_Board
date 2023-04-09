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
public class Applicant extends ModeratableUser implements Position {

    protected String firstName, lastName;

    public Applicant() {
    }

    public Applicant(int userID, String firstName, String lastName, String email, int phoneNumber, String address, String password) {
        super(userID, email, phoneNumber, address, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = false;
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

    // prototype methods
    @Override
    public void loadUsers() {
        //create the variables for each field in the file
        ArrayList<Applicant> applicants = new ArrayList();
        int id = 0;
        String firstname = "";
        String lastname = "";
        String email = "";
        int phone = 0;
        String address = "";
        String password = "";
        boolean active = false;
        int totalrows = 0, index = 0;

        connectDB();

        try {
            //Get the total rows in the table to loop through the result set
            resultSet = statement.executeQuery("SELECT * FROM applicant");
            //resultSet.first();

            totalrows = resultSet.getRow();
            while (resultSet.next()) //tests for the eof
            {
                totalrows = resultSet.getRow();
                id = resultSet.getInt("ID");
                firstname = resultSet.getString("firstName");
                lastname = resultSet.getString("lastName");
                email = resultSet.getString("email");
                phone = resultSet.getInt("phone");
                address = resultSet.getString("address");
                password = resultSet.getString("password");
                active = resultSet.getBoolean("active");
                Applicant a = new Applicant();
                applicants.add(a);
                index++;

            }
            System.out.println(applicants.get(0).toString());
        } catch (SQLException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    // ToDo write code for updateProfile(), deleteProfile(), search(), and apply()
    public void updateProfile() {
    }

    public void deleteProfile() {
    }

    @Override
    public Position addPosition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Position search() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void apply() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void viewPosition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String toString() {
        // int userID, String firstName, String lastName, String email, int phoneNumber, String address, String password
        return "Applicant{" + "user ID: " + userID + ", first name: " + firstName
                + ", last name:" + lastName + ", email: " + email + ", "
                + ", phone number: " + phoneNumber + ", address: " + address
                + ", password: " + password + '}';
    }
}
