package com.group.job_board;

import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class JobPostingMenuController {
    @FXML
    ListView listviewJobs;
    ObservableList<String> items;
    ArrayList<Position> alJobs;
    ArrayList<Employer> alEmployers;

    
    @FXML
    public void initialize(){
        items = listviewJobs.getItems();
    }
    @FXML
    private void switchToSettingsMenu() throws IOException {
        App.setRoot("SettingsMenu");
    }
}
