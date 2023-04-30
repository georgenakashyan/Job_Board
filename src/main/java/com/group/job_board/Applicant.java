package com.group.job_board;

/**
 *
 * @author main
 */
public class Applicant extends ModeratableUser {

    private String firstName, lastName;

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
}