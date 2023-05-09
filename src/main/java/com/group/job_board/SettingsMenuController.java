package com.group.job_board;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class for settings menu
 *
 * @author juilliardwu
 */
public class SettingsMenuController {

    @FXML
    private TextField firstName;
    @FXML
    private TextField firstNameMod;
    @FXML
    private TextField lastName;
    @FXML
    private TextField lastNameMod;
    @FXML
    private TextField companyName;
    @FXML
    private TextField address;
    @FXML
    private TextField addressEmp;
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
    private HBox postingNewJob;
    @FXML
    private HBox addNewMod;
    @FXML
    private HBox moderation;
    
    @FXML
    private VBox appBox;
    @FXML
    private VBox empBox;
    @FXML
    private VBox modBox;

    @FXML
    private Label deleteCheckLabel;
    private int deleteCheck;

    /**
     * Method to initialize the scene
     */
    @FXML
    private void initialize() {
        // Center info boxes for different classes
        appBox.setDisable(true);
        appBox.setVisible(false);
        empBox.setDisable(true);
        empBox.setVisible(false);
        modBox.setDisable(true);
        modBox.setVisible(false);
        email.setText(App.currentUser.getEmail());
        phoneNumber.setText(App.currentUser.getPhone());
        userName.setText(App.currentUser.getUsername());
        deleteCheckLabel.setVisible(false);
        if (App.currentUser instanceof Applicant) {
            // Side Bar
            postingNewJob.setDisable(true);
            postingNewJob.setVisible(false);
            addNewMod.setDisable(true);
            addNewMod.setVisible(false);
            moderation.setDisable(true);
            moderation.setVisible(false);
            // Center Info
            appBox.setDisable(false);
            appBox.setVisible(true);
            Applicant app = (Applicant)App.currentUser;
            firstName.setText(app.getFirstName());
            lastName.setText(app.getLastName());
            address.setText(String.format("%s, %s, %s", app.getRoad(), app.getTown(), app.getState()));
            accountType.setText("Applicant");
        } else if (App.currentUser instanceof Employer) {
            // Side Bar
            addNewMod.setDisable(true);
            addNewMod.setVisible(false);
            moderation.setDisable(true);
            moderation.setVisible(false);
            // Center Info
            empBox.setDisable(false);
            empBox.setVisible(true);
            Employer emp = (Employer)App.currentUser;
            companyName.setText(emp.getCompanyName());
            addressEmp.setText(String.format("%s, %s, %s", emp.getRoad(), emp.getTown(), emp.getState()));  
            accountType.setText("Employer");
        } else if (App.currentUser instanceof Moderator) {
            // Side Bar
            postingNewJob.setDisable(true);
            postingNewJob.setVisible(false);
            // Center Info
            modBox.setDisable(false);
            modBox.setVisible(true);
            Moderator mod = (Moderator)App.currentUser;
            firstNameMod.setText(mod.getFirstName());
            lastNameMod.setText(mod.getLastName());
            accountType.setText("Moderator");
        }
    }

    /**
     * Method to log the user out of the program
     *
     * @throws IOException
     */
    @FXML
    private void SignOutButtonHandler() throws IOException {
        FirestoreContext.logout();
        switchToLogInMenu();
    }

    /**
     * Method to delete a user account
     *
     * @throws IOException
     */
    @FXML
    private void DeleteAccountHandler() throws IOException {
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
        String oldPass = oldPassword.getText();
        String newPass = newPassword.getText();
        if (oldPass.equals(App.currentUser.getPassword())){
            FirestoreContext.changePassword(newPass);
            oldPassword.setText("");
            newPassword.setText("");
        }
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
