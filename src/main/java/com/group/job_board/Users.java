package com.group.job_board;

/**
 * Parent class for all User types
 *
 * @author George / Tim
 */
public abstract class Users {

    protected String phone,
            email,
            password,
            username;

    /**
     * Default constructor
     *
     */
    public Users() {
        this.email = "";
        this.phone = "";
        this.password = "";
    }

    /**
     * Parameterized constructor
     *
     * @param email user's email address
     * @param phoneNumber user's phone number
     * @param password user's password
     * @param username user's username
     */
    public Users(String email, String phoneNumber, String password, String username) {
        this.email = email;
        this.phone = phoneNumber;
        this.password = password;
        this.username = username;
    }

    /**
     * Method to get a user's phone number
     *
     * @return user's phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Method to set a user's phone number
     *
     * @param phone user's phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Method to get a user's email address
     *
     * @return user's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Method to set a user's email address
     *
     * @param email user's email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Method to get a user's password
     *
     * @return user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Method to set a user's password
     *
     * @param password user's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Method to get a user's username
     *
     * @return user's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Method to set a user's username
     *
     * @param username user's username
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
