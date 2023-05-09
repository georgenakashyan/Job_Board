package com.group.job_board;

/**
 * Class for messages and their fields
 * @author main
 */
public class Messages {

    String description;

    /**
     * Default constructor
     * @param description
     */
    public Messages(String description) {
        this.description = description;
    }

    /**
     * getter method for description
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter method for description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    // prototype methods
    public Messages sendMessage(){
        return null;
    }
    public void readMessages() {
    }
}
