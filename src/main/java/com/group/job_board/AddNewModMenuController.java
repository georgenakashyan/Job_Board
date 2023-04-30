package com.group.job_board;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 *
 * @author juilliardwu
 */
public class AddNewModMenuController {
    
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField phone;
    @FXML
    private TextField email;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Label errorMessage;
    
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
    }
    
    @FXML
    private void addModerator() {
        String errorCode = checkValueProblems();
        if (!errorCode.isBlank()) {
            errorMessage.setText(errorCode);
            return;
        }
        HashMap<String, String> map = new HashMap();
        map.put("accountType", "Moderator");
        map.put("email", email.getText());
        map.put("username", username.getText());
        map.put("password", password.getText());
        map.put("firstName", firstName.getText());
        map.put("lastName", lastName.getText());
        map.put("phone", phone.getText());
        
        FirestoreContext.addUser(map);
        errorMessage.setText("New Moderator account, " + username.getText() + ", created.");
    }
    
    private String checkValueProblems() {
        if (firstName.getText().equals(""))
            return "First Name was left blank";
        if (lastName.getText().equals(""))
            return "Last Name was left blank";
        if (phone.getText().equals(""))
            return "Phone Number was left blank";
        if (email.getText().equals(""))
            return "Email was left blank";
        if (username.getText().equals(""))
            return "Username was left blank";
        if (password.getText().equals(""))
            return "Password was left blank";
        try {
            if (FirestoreContext.userExists(email.getText(), username.getText()))
                return "This Moderator already exists";
        } catch (InterruptedException ex) {
            Logger.getLogger(AddNewModMenuController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(AddNewModMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Sets error code to be blank.
        return "";
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
