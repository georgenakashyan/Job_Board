package com.group.job_board;

/**
 * Class for job postings and their methods
 * 
 * @author jimko / George
 */
public class Position {
    String company,
            title,
            description,
            pay,
            street,
            town,
            state,
            remote;
    int spots, jobID;
    
    /**
     * Default constructor
     * 
     */
    public Position() { 
    }

    /**
     * Parameterized constructor
     * 
     * @param company name of company posting the job
     * @param title tile of job posting
     * @param description description of job
     * @param pay pay for the job
     * @param street street for the job location
     * @param town town for the job location
     * @param state state for the job location
     * @param remote indicates if job is remote/in person/ hybrid
     * @param spots number of spots available
     * @param jobID unique ID for job posting
     */
    public Position(String company, String title, String description, String pay, String street, String town, String state, String remote, int spots, int jobID) {
        this.company = company;
        this.title = title;
        this.description = description;
        this.pay = pay;
        this.street = street;
        this.town = town;
        this.state = state;
        this.remote = remote;
        this.spots = spots;
        this.jobID = jobID;
    }

    /**
     * Method to get the name of the company posting the job
     * 
     * @return the company posting the job
     */
    public String getCompany() {
        return company;
    }

    /**
     * Method to set the name of the company posting the job
     * 
     * @param company
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * Method to get the title of the job
     * 
     * @return the title of the job
     */
    public String getTitle() {
        return title;
    }

    /**
     * Method to set the title of the job
     * 
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Method to get the description of the job
     * 
     * @return the description of the job
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method to set the description of the job
     * 
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Method to get the posted payment for the job
     * 
     * @return the posted payment for the job
     */
    public String getPay() {
        return pay;
    }

    /**
     * Method to set the posted payment for the job
     * 
     * @param pay
     */
    public void setPay(String pay) {
        this.pay = pay;
    }

    /**
     * Method to get the street for the job location
     * 
     * @return street for the job location
     */
    public String getStreet() {
        return street;
    }

    /**
     * Method to set the street for the job location
     * 
     * @param street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Method to get the town for the job location
     * 
     * @return the town for the job location
     */
    public String getTown() {
        return town;
    }

    /**
     * Method to set the town for the job location
     * 
     * @param town
     */
    public void setTown(String town) {
        this.town = town;
    }

    /**
     * Method to get the state for the job location
     * 
     * @return the state for the job location
     */
    public String getState() {
        return state;
    }

    /**
     * Method to set the state for the job location
     * 
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Method to get the remote status for the job
     * 
     * @return  remote status for the job
     */
    public String getRemote() {
        return remote;
    }

    /**
     * Method to set the remote status for the job
     * 
     * @param remote
     */
    public void setRemote(String remote) {
        this.remote = remote;
    }

    /**
     * Method to get the number of spots for the job
     * 
     * @return number of spots for the job
     */
    public int getSpots() {
        return spots;
    }

    /**
     * Method to set the number of spots for the job
     * 
     * @param spots
     */
    public void setSpots(int spots) {
        this.spots = spots;
    }

    /**
     * Method to get the unique ID for the job
     * 
     * @return unique ID for the job
     */
    public int getJobID() {
        return jobID;
    }

    /**
     * Method to set the unique ID for the job
     * 
     * @param jobID
     */
    public void setJobID(int jobID) {
        this.jobID = jobID;
    }
}
