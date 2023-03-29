package com.group.job_board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    //TESTING
    Vector<String> applicants; 
    Vector<String> newApplicants; 
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    
    public void connectDB() throws ClassNotFoundException, SQLException {
        // Database variables
        // Step 1: Loading or registering JDBC driver class 
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

    void loadApplicants() throws SQLException {
        //create the variables for each field in the file
        String id = "";
        String first = "";
        String last = "";
        String phone ="";
        String email = "";
        String address = "";
        String password = "";
        int totalrows = 0, index = 0;
        
        //Get the total rows in the table to loop through the result set
        resultSet = statement.executeQuery("SELECT * FROM APPLICANT"); 
        //resultSet.first();
         
        totalrows = resultSet.getRow();
        while (resultSet.next()) //tests for the eof
        {   
            totalrows = resultSet.getRow();
            id = resultSet.getString("ID");
            first = resultSet.getString("firstName");
            last = resultSet.getString("lastName");
            phone = resultSet.getString("phone");
            email = resultSet.getString("email");
            address = resultSet.getString("address");
            password = resultSet.getString("password");
            applicants.add(id);
            index++;
            
            //to test Angel load
            //System.out.println("ID: " + id + "\nFirst: " + first + "\nLast: " + last + "" + "\nPhone: " + phone + "\nemail: " + email + "\ncounty: " + county
            //+ "\npassword: " + password + "\nsecAns: " + secAns + "\njoinDate: " + joinDate);
        }//end of loading to array
        System.out.println(applicants.get(0));
    }



    //Login button
    @FXML
    private void switchJobPostingMenu() throws IOException, ClassNotFoundException, SQLException {
        App.setRoot("JobPostingMenu");
        connectDB();
        applicants = new Vector<String>();
        loadApplicants();

        for (int i = 0; i < applicants.size(); i++) {
            if (userName.getText().equals(applicants.get(i))) {
                System.out.println("Login successful.");
            }
            else {
                exitSystem();
            }
        }
    }

    @FXML
    private void switchToSignUpMenu() throws IOException{
        App.setRoot("SignUpMenu");
    }
    
    public void exitSystem() {
        System.exit(0);  
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
