package com.group.job_board;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author juilliardwu
 */
public class PostingNewJobMenuController {

    @FXML
    private Button UploadJob;

    @FXML
    private TextField jobPay;
    @FXML
    private TextField JobTitle;
    @FXML
    private TextField JobDescription;
    @FXML
    private ChoiceBox JobType;
    ObservableList<String> jt = FXCollections.observableArrayList("Full Time", "Part Time", "Intern");
    @FXML
    private ChoiceBox WorkPlaceType;
    ObservableList<String> wpt = FXCollections.observableArrayList("On-site", "Remote", "Hybrid");
    @FXML
    private TextField JobLocation;
    @FXML
    private TextField Home;
    @FXML
    private TextField setting;

    @FXML
    private Label PostJob;

    @FXML
    private void switchToJobPosting() throws IOException {
        if (PostJob.isPressed() == true) {
            App.setRoot("JobPostingMenu");
        }

    }

    @FXML
    private void UploadJobButtomHandler() {

    }
    
    @FXML
    private void switchToSettingsMenu() throws IOException {
        App.setRoot("SettingsMenu");
    }
    
    @FXML
    private void switchToJobPostingMenu() throws IOException {
        App.setRoot("JobPostingMenu");
    }
}
