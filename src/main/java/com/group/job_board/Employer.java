package com.group.job_board;

/**
 *
 * @author main
 */
public class Employer extends ModeratableUser {

    String companyname;

    public Employer() {
    }
    
    public String getCompanyName() {
        return companyname;
    }

    public void setCompanyName(String companyName) {
        this.companyname = companyName;
    }

    public void addJob() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void removeJob() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
