package com.group.job_board;

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
