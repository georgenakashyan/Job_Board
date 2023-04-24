package com.group.job_board;

/**
 *
 * @author George / Tim
 */
public abstract class Users {

    protected String phone,
            email,
            password,
            username;

    public Users() {
        this.email = "";
        this.phone = "";
        this.password = "";
    }

    public Users(String email, String phoneNumber, String password, String username) {
        this.email = email;
        this.phone = phoneNumber;
        this.password = password;
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
