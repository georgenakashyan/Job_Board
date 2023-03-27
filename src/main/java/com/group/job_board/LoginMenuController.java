package com.group.job_board;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class LoginMenuController {
    
    // tempory variable to hold the password
    private String password;
    @FXML
    private TextField userName;
    @FXML
    private TextField hidePassword;
    @FXML
    private TextField showPassword;
    @FXML
    private ImageView eyeCloseIcon;
    @FXML
    private ImageView eyeOpenIcon;
    
    @FXML
    private void switchJobPostingMenu() throws IOException {
        App.setRoot("JobPostingMenu");
    }
    @FXML
    private void switchToSignUpMenu() throws IOException{
        App.setRoot("SignUpMenu");
    }
    
    /**
     * initialize set default as not showing password.
     */
    @FXML
    private void initialize() {
        showPassword.setVisible(false);
        eyeOpenIcon.setVisible(false);
    }
    
    /**
     * Set both hidepassword textField and showpassword textField connect together, so they both have same text.
     */
    @FXML
    private void HidePasswordOnAction() {
        password = hidePassword.getText();
        showPassword.setText(password);
    }

    /**
     * 
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
}
