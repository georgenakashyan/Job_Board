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
    DatabaseLoad dbl;
    ObservableList<String> items;
    ArrayList<Position> alJobs;
    ArrayList<Poster> alEmployers;

    
    @FXML
    public void initialize(){
        dbl = new DatabaseLoad();
        items = listviewJobs.getItems();
        alJobs = dbl.loadPositions();
        alEmployers = dbl.loadPosters();
        handleLoadFromDB();
    }
    /**
     * This method will load in all relevant data from a Microsoft access
     * database
     */
    @FXML
    private void handleLoadFromDB() {

        for (int i = 1; i < alJobs.size(); i++) {
            items.add(alJobs.get(i).positionTitle);
            
        }
    }
}
