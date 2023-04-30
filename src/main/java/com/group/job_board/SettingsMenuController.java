package com.group.job_board;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
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
        
        //Set all textfield variables to show user's current information.
    }
   
    @FXML
    private void SignOutButtonHandler() throws IOException{
        FirestoreContext.logout();
        switchToLogInMenu();
    }
    
    @FXML
    private void DeleteAccountHandler() throws IOException{
        FirestoreContext.removeUser(App.currentUser.username);
        App.currentUser = null;
        switchToLogInMenu();
    }
    
    @FXML
    private void changePassword() {
        
    }
    
    @FXML
    private void switchToLogInMenu() throws IOException {
        App.setRoot("LoginMenu");
    }
    
    @FXML
    private void switchToJobPostingMenu() throws IOException {
        App.setRoot("JobPostingMenu");
    }

    @FXML
    private void switchToSettingsMenu() throws IOException {
        App.setRoot("SettingsMenu");
    }
    
    @FXML
    private void switchToPostingNewJobMenu() throws IOException {
        App.setRoot("PostingNewJobMenu");
    }
    
    @FXML
    private void switchToAddNewModMenu() throws IOException {
        App.setRoot("AddNewModMenu");
    }
    
    @FXML
    private void switchToModerationMenu() throws IOException {
        App.setRoot("ModerationMenu");
    }
}
