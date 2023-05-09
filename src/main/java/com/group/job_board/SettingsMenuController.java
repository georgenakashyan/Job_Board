package com.group.job_board;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class for settings menu
 * 
 * @author juilliardwu
 */
public class SettingsMenuController {
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField address;
    @FXML
    private TextField email;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField userName;
    @FXML
    private TextField accountType;
    @FXML
    private TextField oldPassword;
    @FXML
    private TextField newPassword;
    @FXML
    private Button ChangePasswordButton;
    @FXML
    private Button SignOutButton;
    @FXML
    private Button DeleteAccountButton;
    @FXML
    private HBox postingNewJob;
    @FXML
    private HBox addNewMod;
    @FXML
    private HBox moderation;
    
    @FXML
    private Label deleteCheckLabel;
    private int deleteCheck;
    
    /**
     * Method to initialize the scene
     */
    @FXML
    private void initialize() {
        deleteCheckLabel.setVisible(false);
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
        
        //Set all textfield variables to show user's current information.
    }
   
    /**
     * Method to log the user out of the program
     * 
     * @throws IOException
     */
    @FXML
    private void SignOutButtonHandler() throws IOException{
        FirestoreContext.logout();
        switchToLogInMenu();
    }
    
    /**
     * Method to delete a user account
     * 
     * @throws IOException
     */
    @FXML
    private void DeleteAccountHandler() throws IOException{
        if (deleteCheck < 1) {
            deleteCheckLabel.setVisible(true);
            deleteCheck++;
        } else {
            FirestoreContext.removeUser(App.currentUser.username);
            App.currentUser = null;
            switchToLogInMenu();
        }
    }
    
    /**
     * Method to change user password
     * 
     */
    @FXML
    private void changePassword() {
        
    }
    
    /**
     * Method to switch to login menu scene
     * 
     * @throws IOException
     */
    @FXML
    private void switchToLogInMenu() throws IOException {
        App.setRoot("LoginMenu");
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
