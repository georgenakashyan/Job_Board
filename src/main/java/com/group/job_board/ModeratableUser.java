package com.group.job_board;

/**
 *
 * @author main
 */
public class ModeratableUser extends Users {

    protected String road;
    protected String town;
    protected String state;

    public ModeratableUser() {
    }

    public ModeratableUser(String road, String town, String state, String email, String phoneNumber, String password, String username) {
        super(email, phoneNumber, password, username);
        this.road = road;
        this.town = town;
        this.state = state;
    }

    

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
