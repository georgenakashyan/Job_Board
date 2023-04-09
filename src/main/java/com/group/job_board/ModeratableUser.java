/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.job_board;

/**
 *
 * @author main
 */
public class ModeratableUser extends User {

    protected String address;

    public ModeratableUser() {
    }

    public ModeratableUser(int userID, String email, int phoneNumber, String address, String password) {
        super(userID, email, phoneNumber, password);

        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // ToDO write code for login() and logout()
    public void login() {
    }

    public void logout() {
    }

}
