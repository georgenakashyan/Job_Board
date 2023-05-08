package com.group.job_board;

/**
 * Class for Moderatable users and their methods
 * 
 * @author main
 */
public class ModeratableUser extends Users {

    protected String road;
    protected String town;
    protected String state;

    /**
     * Default constructor
     * 
     */
    public ModeratableUser() {
    }

    /**
     * Parameterized constructor
     * 
     * @param road Street for user's address
     * @param town Town for user's address
     * @param state State for user's address
     * @param email inherited from parent User class
     * @param phoneNumber inherited from parent User class
     * @param password inherited from parent User class
     * @param username inherited from parent User class
     */
    public ModeratableUser(String road, String town, String state, String email, String phoneNumber, String password, String username) {
        super(email, phoneNumber, password, username);
        this.road = road;
        this.town = town;
        this.state = state;
    }

    /**
     * Method to get road
     * 
     * @return
     */
    public String getRoad() {
        return road;
    }

    /**
     * Method to set road
     * 
     * @param road
     */
    public void setRoad(String road) {
        this.road = road;
    }

    /**
     * Method to get town
     * 
     * @return
     */
    public String getTown() {
        return town;
    }

    /**
     * Method to set town
     * 
     * @param town
     */
    public void setTown(String town) {
        this.town = town;
    }

    /**
     * Method to get state
     * 
     * @return
     */
    public String getState() {
        return state;
    }

    /**
     * Method to set state
     * 
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }
}
