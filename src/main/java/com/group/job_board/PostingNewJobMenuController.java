/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private TextField CompanyName;
    @FXML
    private TextField JobTItle;
    @FXML
    private TextField JobDiscription;
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
    private void switchToSettingMenu() throws IOException {
        if (setting.isPressed() == true) {
            App.setRoot("SettingsMenu");
        }

    }

    @FXML
    private void UploadJobButtomHandler() {

    }

}
