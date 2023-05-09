package com.group.job_board;

/**
 * Class to define all employer users
 * @author main
 */
public class Employer extends ModeratableUser {

    String companyname;

    /**
     * Default constructor
     */
    public Employer() {
    }
    
    /**
     * Getter method to return the company name
     * @return
     */
    public String getCompanyName() {
        return companyname;
    }

    /**
     * Setter method to set the company name
     * @param companyName
     */
    public void setCompanyName(String companyName) {
        this.companyname = companyName;
    }

    /**
     * Method to add a job
     */
    public void addJob() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Method to remove a job
     */
    public void removeJob() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
