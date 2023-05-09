package com.group.job_board;

/**
 * Moderator class and its methods
 * 
 * @author main
 */
public class Moderator extends Users {

    String firstName, lastName;

    /**
     * Default constructor
     * 
     */
    public Moderator() {
    }

    /**
     * Parameterized constructor
     * 
     * @param firstName moderator's first name
     * @param lastName moderator's last name
     * @param email inherited from parent class
     * @param phoneNumber inherited from parent class
     * @param password inherited from parent class
     * @param username inherited from parent class
     */
    public Moderator(String firstName, String lastName, String email, String phoneNumber, String password, String username) {
        super(email, phoneNumber, password, username);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Method to get moderator's first name
     * 
     * @return moderator's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Method to set moderator's first name
     * 
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Method to get moderator's last name
     * 
     * @return moderator's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Method to set moderator's last name
     * 
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     * Method to add a new moderator
     * 
     * @param firstName
     * @param lastName
     * @param email
     * @param phoneNumber
     * @param password
     * @param username
     */
    public void addModerator(String firstName, String lastName, String email, String phoneNumber, String password, String username) {

    }

    /**
     * Method to remove a moderator
     * 
     * @param userID userID of moderator
     */
    public void removeModerator(int userID) {
    }

    /**
     * Method to remove an applicant
     * 
     * @param userID userID of applicant
     */
    public void removeApplicant(int userID) {
    }

    /**
     * Method to remove an employer
     * 
     * @param userID userID of employer
     */
    public void removeEmployer(int userID) {
    }

    /**
     * Method to view jobs
     * 
     */
    private void viewJobs() {
    }

    /**
     * Method to login to program
     * 
     */
    public void login() {
    }

    /**
     * Method to logout of program
     * 
     */
    public void logout() {
    }
}
