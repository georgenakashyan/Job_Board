package com.group.job_board;

import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
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
    @FXML
    private ChoiceBox stateFilter;
    private ObservableList<String> stateItems;
    @FXML
    private ChoiceBox placeFilter;
    private ObservableList<String> placeItems;
    @FXML
    private ChoiceBox typeFilter;
    private ObservableList<String> typeItems;
    @FXML
    private ChoiceBox payFilter;
    private ObservableList<String> payItems;

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
        stateItems = FXCollections.observableArrayList("AL", "AK", "AZ", "AR", "CA",
                "CO", "CT", "DE", "FL", "GA",
                "HI", "ID", "IL", "IN", "IA",
                "KS", "KY", "LA", "ME", "MD",
                "MA", "MI", "MN", "MS", "MO",
                "MT", "NE", "NV", "NH", "NJ",
                "NM", "NY", "NC", "ND", "OH",
                "OK", "OR", "PA", "RI", "SC",
                "SD", "TN", "TX", "UT", "VT",
                "VA", "WA", "WV", "WI", "WY");
        stateFilter.setItems(stateItems);
        placeItems = FXCollections.observableArrayList("On-site", "Hybrid", "Remote");
        placeFilter.setItems(placeItems);
        typeItems = FXCollections.observableArrayList("Full-Time", "Part-Time", "Intern");
        typeFilter.setItems(typeItems);
        payItems = FXCollections.observableArrayList("$15-$20", "$20-$25", "$25-$30", "$30-$40", "$40+");
        payFilter.setItems(payItems);
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

    @FXML
    private void filterState() {
        int index = stateFilter.getSelectionModel().getSelectedIndex();
        if (index != -1) {
            String filter = stateItems.get(index);
            for (Position p : jobArr) {
                if (!p.getState().equals(filter)) {
                    jobArr.remove(p);
                }
            }
        }
    }

    @FXML
    private void filterPlace() {
        int index = placeFilter.getSelectionModel().getSelectedIndex();
        if (index != -1) {
            String filter = placeItems.get(index);
            for (Position p : jobArr) {
                if (!p.getType().equals(filter)) {
                    jobArr.remove(p);
                }
            }
        }
    }

    @FXML
    private void filterType() {
        int index = typeFilter.getSelectionModel().getSelectedIndex();
        if (index != -1) {
            String filter = typeItems.get(index);
            for (Position p : jobArr) {
                if (!p.getRemote().equals(filter)) {
                    jobArr.remove(p);
                }
            }
        }
    }

    @FXML
    private void filterPay() {
        int index = payFilter.getSelectionModel().getSelectedIndex();
        if (index != -1) {
            String filter = payItems.get(index);
            for (Position p : jobArr) {
                if (String.valueOf(p.getPay()).contains(filter.substring(1, 2))) {
                    jobArr.remove(p);
                }
            }
        }
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
            Employer emp = (Employer) App.currentUser;
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
            Employer emp = (Employer) App.currentUser;
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
            String s = App.currentUser.getClass().toString().replace("class com.group.job_board.", "");
            if (s.equals("Moderator")) {
                JobTitle.setText(JobTitle.getText() + "<ID:" + p.getJobID()+ ">");
            }
        }
    }

    /**
     * Method to switch to job posting menu
     *
     * @throws IOException
     */
    @FXML
    private void switchToJobPostingMenu() throws IOException {
        App.setRoot("JobPostingMenu");
    }

    /**
     * Method to switch to the settings menu
     *
     * @throws IOException
     */
    @FXML
    private void switchToSettingsMenu() throws IOException {
        App.setRoot("SettingsMenu");
    }

    /**
     * Method to switch to the posting new job menu
     *
     * @throws IOException
     */
    @FXML
    private void switchToPostingNewJobMenu() throws IOException {
        App.setRoot("PostingNewJobMenu");
    }

    /**
     * Method to switch to the add new moderator menu
     *
     * @throws IOException
     */
    @FXML
    private void switchToAddNewModMenu() throws IOException {
        App.setRoot("AddNewModMenu");
    }

    /**
     * Method to switch to moderator menu
     *
     * @throws IOException
     */
    @FXML
    private void switchToModerationMenu() throws IOException {
        App.setRoot("ModerationMenu");
    }
}
