package com.group.job_board;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML controller class for the login menu
 */
public class LoginMenuController {

    private String password;
    @FXML
    private TextField email;
    @FXML
    private Label errorMessage;
    @FXML
    private TextField hidePassword;
    @FXML
    private TextField showPassword;
    @FXML
    private ImageView eyeCloseIcon;
    @FXML
    private ImageView eyeOpenIcon;
    private int numAtt = 0;

    /**
     * Initialize the scene
     */
    @FXML
    private void initialize() {
        errorMessage.setText("");
        showPassword.setVisible(false);
        eyeOpenIcon.setVisible(false);
        password = "";
    }

    /**
     * Method to switch to the job posts menu screen
     * @throws IOException
     */
    @FXML
    private void switchJobPostingMenu() throws IOException {
        String errorCode = checkValueProblems();
        if (!errorCode.isBlank()) {
            errorMessage.setText(errorCode);
            return;
        }
        FirestoreContext.login(email.getText().toLowerCase(), password);
        if (App.currentUser != null) {
            System.out.println("Login successful.");
            App.setRoot("JobPostingMenu");
        } else {
            errorMessage.setText("Email or password is not correct");
            numAtt++;
            if(numAtt > 3)
                System.exit(numAtt);
        }
    }

    /**
     * Method to switch to the sign up menu
     * @throws IOException
     */
    @FXML
    private void switchToSignUpMenu() throws IOException {
        App.setRoot("SignUpMenu");
    }

    /**
     * Set both hidepassword textField and showpassword textField connect
     * together, so they both have same text.
     */
    @FXML
    private void HidePasswordOnAction() {
        password = hidePassword.getText();
        showPassword.setText(password);
    }

    /**
     * When clicked password will show
     */
    @FXML
    private void ShowPasswordOnAction() {
        password = showPassword.getText();
        hidePassword.setText(password);
    }

    /**
     * When user click close eye icon the on action will be switch to the other.
     */
    @FXML
    private void closeEyeOnAction() {
        showPassword.setVisible(true);
        eyeCloseIcon.setVisible(false);
        eyeOpenIcon.setVisible(true);
        hidePassword.setVisible(false);
    }

    /**
     * When user clock open eye icon the on action will switch to the other.
     */
    @FXML
    private void openEyeOnAction() {
        showPassword.setVisible(false);
        eyeCloseIcon.setVisible(true);
        eyeOpenIcon.setVisible(false);
        hidePassword.setVisible(true);
    }
    
    /**
     * Method to check any blank fields or errors in the login
     * @return
     */
    private String checkValueProblems() {
        if (email.getText().equals(""))
            return "Email was left blank";
        if (password.equals(""))
            return "Password was left blank";
        //Sets error code to be blank.
        return "";
    }
}
