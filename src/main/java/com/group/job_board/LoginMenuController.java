package com.group.job_board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Vector;

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

    ArrayList<Applicant> applicants; 
    DatabaseLoad dbl;
    Vector<Applicant> newApplicants; 
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    int numAtt = 0;
    
    @FXML
    private void initialize() {
        showPassword.setVisible(false);
        eyeOpenIcon.setVisible(false);
        dbl = new DatabaseLoad();
    }
    
    //Login button
    @FXML
    private void switchJobPostingMenu() throws IOException {
        applicants = dbl.loadApplicants();
        boolean userLoggedIn = false;
        numAtt++;
        
        
        for (int i = 0; i < applicants.size(); i++) {
            if (userName.getText().equals(applicants.get(i).getUsername()) && showPassword.getText().equals(applicants.get(i).getPassword())) {
                System.out.println("Login successful.");
                userLoggedIn = true;
                App.setRoot("JobPostingMenu");
            }
        }
        if(userLoggedIn == false) {
            System.out.println("Login Unsuccessful");
            if(numAtt > 3)
                System.out.println("Attempt limit reached!"); //Possibly do more, maybe a better error message?
        }
    }

    @FXML
    private void switchToSignUpMenu() throws IOException{
        App.setRoot("SignUpMenu");
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
