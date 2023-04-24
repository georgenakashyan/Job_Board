package com.group.job_board;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
    private void initialize() {
        //Set all textfield variables to show user's current information.
    }
   
    @FXML
    private void SignOutButtonHandler() throws IOException{
        FirestoreContext.logout();
        switchToLogInMenu();
    }
    
    @FXML
    private void DeleteAccountHandler(){
        
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
    private void switchToNewJobPostMenu() throws IOException {
        App.setRoot("PostingNewJobMenu");
    }
}
