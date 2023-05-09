package com.group.job_board;

/**
 * Class to define applicant users
 * @author main
 */
public class Applicant extends ModeratableUser {

    private String firstName, lastName;

    /**
     * Default constructor
     */
    public Applicant() {
    }

    /**
     * Parameterized constructor
     * @param firstName
     * @param lastName
     * @param road
     * @param town
     * @param state
     * @param email
     * @param phoneNumber
     * @param password
     * @param username
     */
    public Applicant(String firstName, String lastName, String road, String town, String state, String email, String phoneNumber, String password, String username) {
        super(road, town, state, email, phoneNumber, password, username);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Getter method to return first name
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter method to set first name
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter method to return last name
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter method to set last name
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // ToDo write code for updateProfile(), deleteProfile(), search(), and apply()
    public void updateProfile() {
    }

    public void deleteProfile() {
    }
}