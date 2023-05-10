package com.group.job_board;

import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * FXML controller class for the job posting menu
 */
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
    
    /**
     * FXML fields for this controller
     */
    @FXML
    private HBox moderation;
    private ObservableList<String> items;
    private ArrayList<Position> jobArr;

    /**
     * Initialize the scene and set up the list view
     */
    @FXML
    private void initialize() {
        description.setWrapText(true);
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
        loadJobs();
    }
    
    /**
     * Method to search the job postings
     */
    @FXML
    private void search() {
        if (items.isEmpty()) {
            loadJobs();
            return;
        }
        jobArr.clear();
        items.clear();
        String s = App.currentUser.getClass().toString().replace("class com.group.job_board.", "");
        if (s.contains("Employer")) {
            Employer emp = (Employer)App.currentUser;
            jobArr = FirestoreContext.searchEmployerJobPostings(emp.getCompanyName(), searchBar.getText());
        } else {
            jobArr = FirestoreContext.searchJobPostings(searchBar.getText());
        }
        for (Position p : jobArr) {
            items.add(String.format("Company - %s\n   Job - %s\n   $%.2f", p.getCompany(), p.getTitle(), p.getPay()));
        }
    }
    
    /**
     * Method to load jobs from the database
     */
    private void loadJobs() {
        jobArr.clear();
        items.clear();
        String s = App.currentUser.getClass().toString().replace("class com.group.job_board.", "");
        if (s.equals("Employer")) {
            Employer emp = (Employer)App.currentUser;
            jobArr = FirestoreContext.getEmployerJobPostings(emp.getCompanyName());
            return;
        } else {
            jobArr = FirestoreContext.getAllJobPostings();
        }
        for (Position p : jobArr) {
            items.add(String.format("Company - %s\n   Job - %s\n   $%.2f", p.getCompany(), p.getTitle(), p.getPay()));
        }
    }
    
    @FXML
    private void handleJobClick() {
        int selection = listviewJobs.getSelectionModel().getSelectedIndex();
        Position p = jobArr.get(selection);
        if (p != null) {
            JobTitle.setText(p.getTitle());
            companyname.setText(p.getCompany());
            state.setText(p.getState());
            town.setText(p.getTown());
            road.setText(p.getStreet());
            jobType.setText(p.getType());
            paid.setText("$" + String.valueOf(p.getPay()));
            description.setText(p.getDescription());
        }
    }

    /**
     * Method to switch to job posting menu
     * @throws IOException
     */
    @FXML
    private void switchToJobPostingMenu() throws IOException {
        App.setRoot("JobPostingMenu");
    }

    /**
     * Method to switch to the settings menu
     * @throws IOException
     */
    @FXML
    private void switchToSettingsMenu() throws IOException {
        App.setRoot("SettingsMenu");
    }
    
    /**
     * Method to switch to the posting new job menu
     * @throws IOException
     */
    @FXML
    private void switchToPostingNewJobMenu() throws IOException {
        App.setRoot("PostingNewJobMenu");
    }
    
    /**
     * Method to switch to the add new moderator menu
     * @throws IOException
     */
    @FXML
    private void switchToAddNewModMenu() throws IOException {
        App.setRoot("AddNewModMenu");
    }
    
    /**
     * Method to switch to moderator menu
     * @throws IOException
     */
    @FXML
    private void switchToModerationMenu() throws IOException {
        App.setRoot("ModerationMenu");
    }
}
