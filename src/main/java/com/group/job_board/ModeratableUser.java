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

    public ModeratableUser(String address, int userID, String username, String password, long phone, String email, boolean active) {
        super(userID, username, password, phone, email, active);
        this.address = address;
    }

    // method prototypes
    public void login() {
    }

    public void logout() {
    }

}
