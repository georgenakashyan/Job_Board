/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group.job_board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
