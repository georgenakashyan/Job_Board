package com.group.job_board;

import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class JobPostingMenuController {

    @FXML
    private ListView listviewJobs;
    @FXML
    private HBox postingNewJob;
    @FXML
    private HBox addNewMod;
    @FXML
    private TextField searchBar;
    @FXML
    private Label JobTitle;
    @FXML
    private Label companyname;
    @FXML
    private Label state;
    @FXML
    private Label town;
    @FXML
    private Label road;
    @FXML
    private Label jobType;
    @FXML
    private Label paid;
    @FXML
    private Label description;
            
    @FXML
    private HBox moderation;
    private ObservableList<String> items;
    private ArrayList<Position> jobArr;

    @FXML
    private void initialize() {
        items = listviewJobs.getItems();
        jobArr = new ArrayList<>();
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
    private void search() {
        jobArr.clear();
        items.clear();
        jobArr = FirestoreContext.searchJobPostings(searchBar.getText());
        for (Position p : jobArr) {
            items.add(String.format("Company - %s\n   Job - %s\n   $%.2f", p.getCompany(), p.getTitle(), p.getPay()));
        }
    }

    @FXML
    private void switchToJobPostingMenu() throws IOException {
        App.setRoot("JobPostingMenu");
    }

    @FXML
    private void switchToSettingsMenu() throws IOException {
        App.setRoot("SettingsMenu");
    }
    
    @FXML
    private void switchToPostingNewJobMenu() throws IOException {
        App.setRoot("PostingNewJobMenu");
    }
    
    @FXML
    private void switchToAddNewModMenu() throws IOException {
        App.setRoot("AddNewModMenu");
    }
    
    @FXML
    private void switchToModerationMenu() throws IOException {
        App.setRoot("ModerationMenu");
    }
}
