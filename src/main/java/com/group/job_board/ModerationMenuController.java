package com.group.job_board;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class for moderator's menu
 * 
 * @author juilliardwu
 */
public class ModerationMenuController {
    
    @FXML
    private HBox postingNewJob;
    @FXML
    private HBox addNewMod;
    @FXML
    private HBox moderation;
    
    @FXML
    private TextField delUserName;
    @FXML
    private TextField delPostID;
    
    /**
     * Method to initialize the scene
     * 
     */
    @FXML
    private void initialize() {
        String s = App.currentUser.getClass().toString().replace("class com.group.job_board.", "");
        switch (s) {
            case "Applicant":
                postingNewJob.setDisable(true);
                postingNewJob.setVisible(false);
                addNewMod.setDisable(true);
                addNewMod.setVisible(false);
                moderation.setDisable(true);
                moderation.setVisible(false);
                break;
            case "Employer":
                addNewMod.setDisable(true);
                addNewMod.setVisible(false);
                moderation.setDisable(true);
                moderation.setVisible(false);
                break;
            case "Moderator":
                postingNewJob.setDisable(true);
                postingNewJob.setVisible(false);
                break;
        }
    }
    
    @FXML
    private void deleteUser() {
        if (!delUserName.getText().isEmpty())
            FirestoreContext.removeUser(delUserName.getText());
    }
    
    @FXML
    private void deletePost() {
        if (!delPostID.getText().isEmpty())
            FirestoreContext.removeJobPosting(Integer.getInteger(delPostID.getText()));
    }
    
    /**
     * Method to switch to job posting menu scene
     * 
     * @throws IOException
     */
    @FXML
    private void switchToJobPostingMenu() throws IOException {
        App.setRoot("JobPostingMenu");
    }

    /**
     * Method to switch to settings scene
     * 
     * @throws IOException
     */
    @FXML
    private void switchToSettingsMenu() throws IOException {
        App.setRoot("SettingsMenu");
    }
    
    /**
     * Method to switch to new job posting menu scene
     * 
     * @throws IOException
     */
    @FXML
    private void switchToPostingNewJobMenu() throws IOException {
        App.setRoot("PostingNewJobMenu");
    }
    
    /**
     * Method to switch to add new moderator menu scene
     * 
     * @throws IOException
     */
    @FXML
    private void switchToAddNewModMenu() throws IOException {
        App.setRoot("AddNewModMenu");
    }
    
    /**
     * Method to switch to moderator menu scene
     * 
     * @throws IOException
     */
    @FXML
    private void switchToModerationMenu() throws IOException {
        App.setRoot("ModerationMenu");
    }
}
