package com.group.job_board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 *
 * @author juilliardwu
 */
public class SignUpMenuController {
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
    private Label errorMessage;
    @FXML
    private TextField userName;
    @FXML
    private TextField hidePassword;
    @FXML
    private TextField showPassword;
    @FXML
    private TextField showReEnterPassword;
    @FXML
    private TextField hideReEnterPassword;
    @FXML
    private ImageView eyeCloseIcon;
    @FXML
    private ImageView eyeOpenIcon;

    private Boolean passwordShowing;
    @FXML
    private ChoiceBox UserIdentityChoiceBox;

    Connection connection;
    Statement statement;
    ResultSet resultSet;
    
    ObservableList<String> UserIdentity = FXCollections.observableArrayList("Employer","Applicant");

    @FXML
    private void switchToLogInMenu() throws IOException {
        App.setRoot("LoginMenu");
    }
    @FXML
    private void SignUpButtonHandler() throws ClassNotFoundException, SQLException {
        String errorCode = checkValueProblems();
        if (!errorCode.isBlank()) {
            errorMessage.setText(errorCode);
            return;
        }
        String password = "";

        //Gets password from either shown or hidden text fields
        if(showPassword.getText().equals(""))
            password = hidePassword.getText();
        else
            password = showPassword.getText();

        if(UserIdentityChoiceBox.getValue().equals("Applicant")) {
            
        } else if(UserIdentityChoiceBox.getValue().equals("Employer")) {
            
        }
        
        //After successfully creating account, automatically log them in.
        try {
            switchToLogInMenu();
        } catch (IOException ex) {
            Logger.getLogger(SignUpMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String checkValueProblems() {
        if (firstName.getText().equals(""))
            return "First Name was left blank";
        if (lastName.getText().equals(""))
            return "Last Name was left blank";
        if (address.getText().equals(""))
            return "Address was left blank";
        if (email.getText().equals(""))
            return "Email was left blank";
        if (phoneNumber.getText().equals(""))
            return "Phone Number was left blank";
        if (userName.getText().equals(""))
            return "Username was left blank";
        if (UserIdentityChoiceBox.getValue() == null)
            return "Please select an account type";
        if (passwordBlank())
            return "Password was left blank";
        if (!passwordMatch())
            return "Passwords don't match";
        //Sets error code to be blank.
        return "";
    }

    public void connectDB() throws ClassNotFoundException, SQLException { 
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 		 
        // Step 2: Opening database connection
        String msAccDB = "codeangels.accdb";
        String dbURL = "jdbc:ucanaccess://" + msAccDB; 
        // Step 3: Create and get connection using DriverManager class
        connection = DriverManager.getConnection(dbURL); 
        // Step 4: Creating JDBC Statement 
        // It is scrollable so we can use next() and last() & It is updatable so we can enter new records
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_UPDATABLE);
        System.out.println("Database Connected!");
    }

    /**
     * initialize set default as not showing password.
     */
    @FXML
    private void initialize() {
        showPassword.setVisible(false);
        showReEnterPassword.setVisible(false);
        eyeOpenIcon.setVisible(false);
        errorMessage.setText("");
        passwordShowing = false;
        UserIdentityChoiceBox.setItems(UserIdentity);
        
    }
    
    /**
     * When user clicks either the open or closed eye icon
     * the password visibility will flip.
     */
    @FXML
    private void eyeOnAction() {
        if (passwordShowing) {
            showPassword.setVisible(false);
            showReEnterPassword.setVisible(false);
            eyeCloseIcon.setVisible(true);
            eyeOpenIcon.setVisible(false);
            hidePassword.setVisible(true);
            hideReEnterPassword.setVisible(true);
            String password = showPassword.getText();
            hidePassword.setText(password);
            password = showReEnterPassword.getText();
            hideReEnterPassword.setText(password);
            passwordShowing = false;
        } else {
            showPassword.setVisible(true);
            showReEnterPassword.setVisible(true);
            eyeCloseIcon.setVisible(false);
            eyeOpenIcon.setVisible(true);
            hidePassword.setVisible(false);
            hideReEnterPassword.setVisible(false);
            String password = hidePassword.getText();
            showPassword.setText(password);
            password = hideReEnterPassword.getText();
            showReEnterPassword.setText(password);
            passwordShowing = true;
        }
    }

    @FXML
    private boolean passwordMatch() {
        String p1, p2;
        if (passwordShowing) {
            p1 = showReEnterPassword.getText();
            p2 = showPassword.getText();
        } else {
            p1 = hideReEnterPassword.getText();
            p2 = hidePassword.getText();
        }
        return (p1.equals(p2));
    }
    
    private boolean passwordBlank() {
        String p1, p2;
        if (passwordShowing) {
            p1 = showReEnterPassword.getText();
            p2 = showPassword.getText();
        } else {
            p1 = hideReEnterPassword.getText();
            p2 = hidePassword.getText();
        }
        return (p1.isBlank() || p2.isBlank());
    }
}
