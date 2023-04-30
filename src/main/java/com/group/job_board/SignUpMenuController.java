package com.group.job_board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author juilliardwu / george
 */
public class SignUpMenuController {

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField road;
    @FXML
    private TextField town;
    @FXML
    private TextField state;
    @FXML
    private TextField companyName;
    @FXML
    private TextField address;
    @FXML
    private TextField email;
    @FXML
    private TextField phoneNumber;
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
    private HBox employerBox;
    @FXML
    private VBox applicantBox;

    @FXML
    private ImageView eyeCloseIcon;
    @FXML
    private ImageView eyeOpenIcon;
    @FXML
    private ChoiceBox UserIdentityChoiceBox;
    @FXML
    private Label errorMessage;

    String password;
    String rePassword;
    private Boolean passwordShowing;
    ObservableList<String> UserIdentity;

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
        UserIdentity = FXCollections.observableArrayList("Employer", "Applicant");
        UserIdentityChoiceBox.setItems(UserIdentity);
        UserIdentityChoiceBox.setValue("Applicant");
        employerBox.setDisable(true);
        employerBox.setVisible(false);
        UserIdentityChoiceBox.setOnAction(event -> {
            userIdentityOnAction();
        });
    }

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
        // Inserting into DB
        HashMap<String, String> map = new HashMap();
        if (UserIdentityChoiceBox.getValue().equals("Applicant")) {
            map.put("accountType", "Applicant");
            map.put("email", email.getText());
            map.put("username", userName.getText());
            map.put("password", password);
            map.put("firstName", firstName.getText());
            map.put("lastName", lastName.getText());
            map.put("phone", phoneNumber.getText());
            map.put("road", road.getText());
            map.put("town", town.getText());
            map.put("state", state.getText());

            FirestoreContext.addUser(map);
            errorMessage.setText("New account, " + userName.getText() + ", created.");
        } else if (UserIdentityChoiceBox.getValue().equals("Employer")) {
            map.put("accountType", "Employer");
            map.put("email", email.getText());
            map.put("username", userName.getText());
            map.put("password", password);
            map.put("companyname", companyName.getText());
            map.put("phone", phoneNumber.getText());
            map.put("road", road.getText());
            map.put("town", town.getText());
            map.put("state", state.getText());

            FirestoreContext.addUser(map);
            errorMessage.setText("New account, " + userName.getText() + ", created.");
        }
    }

    private String checkValueProblems() {
        if (UserIdentityChoiceBox.getValue().equals("Applicant")) {
            if (firstName.getText().equals("")) {
                return "First Name was left blank";
            }
            if (lastName.getText().equals("")) {
                return "Last Name was left blank";
            }
        } else {
            if (companyName.getText().equals("")) {
                return "Company Name was left blank";
            }
        }
        if (address.getText().equals("")) {
            return "Address was left blank";
        }
        if (email.getText().equals("")) {
            return "Email was left blank";
        }
        if (phoneNumber.getText().equals("")) {
            return "Phone Number was left blank";
        }
        if (userName.getText().equals("")) {
            return "Username was left blank";
        }
        if (UserIdentityChoiceBox.getValue() == null) {
            return "Please select an account type";
        }
        if (passwordBlank()) {
            return "Password was left blank";
        }
        if (!passwordMatch()) {
            return "Passwords don't match";
        }
        try {
            if (FirestoreContext.userExists(email.getText(), userName.getText()))
                return "This User already exists.";
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(SignUpMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    private void userIdentityOnAction() {
        if (UserIdentityChoiceBox.getValue().equals("Applicant")) {
            employerBox.setDisable(true);
            employerBox.setVisible(false);
            applicantBox.setDisable(false);
            applicantBox.setVisible(true);
        } else {
            employerBox.setDisable(false);
            employerBox.setVisible(true);
            applicantBox.setDisable(true);
            applicantBox.setVisible(false);
        }
    }
    
    /**
     * When user clicks either the open or closed eye icon the password
     * visibility will flip.
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
            passwordShowing = false;
        } else {
            showPassword.setVisible(true);
            showReEnterPassword.setVisible(true);
            eyeCloseIcon.setVisible(false);
            eyeOpenIcon.setVisible(true);
            hidePassword.setVisible(false);
            hideReEnterPassword.setVisible(false);
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
        if (p1.equals(p2)) {
            password = p1;
            return true;
        }
        return false;
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
