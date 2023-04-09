/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.job_board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author main
 */
public class Moderator extends User {

    String firstName, lastName;

    public Moderator() {
    }

    public Moderator(int userID, String firstName, String lastName, String email, int phoneNumber, boolean status, String password) {
        super(userID, email, phoneNumber, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
    }

    // method prototypes
    @Override
    public void loadUsers() {
        //create the variables for each field in the file
        ArrayList<Moderator> moderators = new ArrayList();
        int id = 0;
        String firstname = "";
        String lastname = "";
        String email = "";
        int phone = 0;
        boolean active = false;
        String password = "";
        int totalrows = 0, index = 0;

        connectDB();

        try {
            //Get the total rows in the table to loop through the result set
            resultSet = statement.executeQuery("SELECT * FROM MODERATOR");
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
                active = resultSet.getBoolean("active");
                password = resultSet.getString("password");
                Moderator m = new Moderator();
                moderators.add(m);
                index++;

            }
            System.out.println(moderators.get(0).toString());
        } catch (SQLException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public void addModerator(int userID, String firstName, String lastName, String email, int phoneNumber, boolean status, String password) {
        connectDB(); // if any issues arise try putting this in the try-catch block

        try {
            String sql = "INSERT INTO MODERATOR (firstName, lastName, email, phone, active, password) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, userID);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, email);
            preparedStatement.setInt(5, phoneNumber);
            preparedStatement.setBoolean(6, status);
            preparedStatement.setString(7, password);

            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                System.out.println("Row inserted");;
            }
        } catch (SQLException e) {
        }

    }

    public void removeModerator(int userID) {
        try {
            connectDB();
            String sql = "DELETE FROM MODERATOR WHERE userID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, userID);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted == 0) {
                System.out.println("Moderator does not exist.");
            } else {
                System.out.println("Moderator deleted.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Moderator.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void removeApplicant(int userID) {
        try {
            connectDB();
            String sql = "DELETE FROM APPLICANT WHERE userID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, userID);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted == 0) {
                System.out.println("Applicant does not exist.");
            } else {
                System.out.println("Applicant deleted.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Moderator.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void removeEmployer(int userID) {
        try {
            connectDB();
            String sql = "DELETE FROM EMPLOYER WHERE userID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, userID);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted == 0) {
                System.out.println("Employer does not exist.");
            } else {
                System.out.println("Employer deleted.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Moderator.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void viewJobs() {
        ArrayList<String> jobs = new ArrayList();
        int id = 0;
        String positionTitle = "";
        String positionDesc = "";
        int positionPay = 0;
        int positionSponsor = 0; // ask Jimmy or Jake what this number means
        String positionAddress = "";
        boolean remote = false;
        boolean active = false;
        int totalrows = 0, index = 0;

        connectDB();

        try {
            //Get the total rows in the table to loop through the result set
            resultSet = statement.executeQuery("SELECT * FROM POSITION");
            //resultSet.first();

            totalrows = resultSet.getRow();
            while (resultSet.next()) //tests for the eof
            {
                totalrows = resultSet.getRow();
                id = resultSet.getInt("ID");
                positionTitle = resultSet.getString("positionTitle");
                positionDesc = resultSet.getString("positionDesc");
                positionPay = resultSet.getInt("positionPay");
                positionSponsor = resultSet.getInt("positionSponsor");
                positionAddress = resultSet.getString("positionAddress");
                remote = resultSet.getBoolean("Remote");
                active = resultSet.getBoolean("Active");
                String str = String.format("Title: %s, Description: %s, "
                        + "Pay: $%d, Address: %s, Remote: %b, Status: %b",
                        positionTitle, positionDesc, positionPay,
                        positionAddress, remote, active);
                jobs.add(str);
                index++;

            }
            System.out.println(jobs.get(0));
        } catch (SQLException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    // ToDo write code for approveJobs(), login(), and logout()
    private void approveJobs() {
    }

    public void login() {
    }

    public void logout() {
    }

    @Override
    public String toString() {
        // int userID, String firstName, String lastName, String email, int phoneNumber, boolean status, String password
        return "Moderator{" + "user ID: " + userID + ", first name: " + firstName
                + ", last name:" + lastName + ", email: " + email + ", "
                + ", phone number: " + phoneNumber + ", status: " + status
                + ", password: " + password + '}';
    }

}
