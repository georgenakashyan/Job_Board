package com.group.job_board;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class for posting new jobs
 *
 * @author juilliardwu
 */
public class PostingNewJobMenuController {

    @FXML
    private TextField JobTitle;
    @FXML
    private TextField JobDescription;
    @FXML
    private TextField jobPay;
    @FXML
    private TextField spots;
    @FXML
    private ChoiceBox JobType;
    private ObservableList<String> jt;
    @FXML
    private ChoiceBox WorkPlaceType;
    private ObservableList<String> wpt;
    @FXML
    private TextField town;
    @FXML
    private TextField street;
    @FXML
    private TextField state;
    
    @FXML
    private HBox postingNewJob;
    @FXML
    private HBox addNewMod;
    @FXML
    private HBox moderation;
    
     /**
     * Method to initialize the scene
     * 
     */
    @FXML
    private void initialize() {
        jt = FXCollections.observableArrayList("Full-Time", "Part-Time", "Intern");
        JobType.setItems(jt);
        wpt = FXCollections.observableArrayList("On-site", "Remote", "Hybrid");
        WorkPlaceType.setItems(wpt);
        
        String s = App.currentUser.getClass().toString().replace("class com.group.job_board.", "");
        switch (s) {
            case "Applicant":
                postingNewJob.setDisable(true);
                postingNewJob.setVisible(false);
                addNewMod.setDisable(true);
                addNewMod.setVisible(false);
                moderation.setDisable(true);
                moderation.setVisible(false);
                break;
            case "Employer":
                addNewMod.setDisable(true);
                addNewMod.setVisible(false);
                moderation.setDisable(true);
                moderation.setVisible(false);
                break;
            case "Moderator":
                postingNewJob.setDisable(true);
                postingNewJob.setVisible(false);
                break;
        }
    }
    
    @FXML
    private void UploadJobButtonHandler() {
        int newJobID = FirestoreContext.getNewJobID();
        Employer emp = (Employer) App.currentUser;
        Position p = new Position(emp.getCompanyName(), 
                JobTitle.getText(), JobDescription.getText(), 
                street.getText(), town.getText(), state.getText(), 
                wpt.get(WorkPlaceType.getSelectionModel().getSelectedIndex()), 
                jt.get(JobType.getSelectionModel().getSelectedIndex()), 
                Double.valueOf(jobPay.getText()),
                Integer.valueOf(spots.getText()), newJobID);
        FirestoreContext.addJobPosting(p);
    }

    /**
     * Method to switch to job postings scene
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
