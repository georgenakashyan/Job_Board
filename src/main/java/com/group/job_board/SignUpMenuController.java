package com.group.job_board;


import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

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
    
    ObservableList<String> UserIdentity = FXCollections.observableArrayList("Poster","Applicant");

    @FXML
    private void switchToLogInMenu() throws IOException {
        App.setRoot("LoginMenu");
    }
    @FXML
    private void SignUpButtonHandler() throws ClassNotFoundException, SQLException {
        connectDB();

        String id = "";
        String username = "";
        String first = "";
        String last = "";
        String phone ="";
        String email = "";
        String address = "";
        String password = "";
        boolean active = true;

        Applicant newApp = new Applicant(userName.getText(), showPassword.getText());

        username = newApp.getUsername();
        password = newApp.getPassword();

        //TEMPORARY DUMMY VALUES BELOW
        id = "2";
        first = "John";
        last = "Doe";
        phone = "6316432718";
        email = "johndoe@gmail.com";
        address = "6 Apple Lane";

        statement.executeUpdate("INSERT INTO APPLICANT VALUES ("
            + "'"+ id +"',"
            + "'"+ first +"', "
            + "'"+ last +"', "
            + "'"+ email +"', "
            + "'"+ phone +"', "
            + "'"+ address +"', "
            + "'"+ password +"', "
            + "'"+ active +"', "
            + "'"+ username +"')");				
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
        errorMessage.setVisible(false);
        passwordShowing = false;
        //initialize choicebox
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
        if (passwordShowing) {
            if (!(showReEnterPassword.getText().equals(showPassword.getText()))) {
                errorMessage.setVisible(true);
                return false;
            }
        } else {
            if (!(hideReEnterPassword.getText().equals(hidePassword.getText()))) {
                errorMessage.setVisible(true);
                return false;
            }
        }
        errorMessage.setVisible(false);
        return true;
    }
}
