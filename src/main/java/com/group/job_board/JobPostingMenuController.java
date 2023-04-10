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
    ObservableList<String> items = listviewJobs.getItems();
    ArrayList<Position> alJobs = new ArrayList();

    
    @FXML
    public void initialize(){
        handleLoadFromDB();
    }
    /**
     * This method will load in all relevant data from a Microsoft access
     * database
     */
    @FXML
    private void handleLoadFromDB() {
        String databaseURL = "";
        Connection conn = null;
        
        
        // establishing connection
        try {
            databaseURL = "jdbc:ucanaccess://.//CodeAngels.accdb";
            conn = DriverManager.getConnection(databaseURL);
        } catch (SQLException ex) {
            Logger.getLogger(JobPostingMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            String tableName = "position";
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("select * from " + tableName);
            conn.close();
            while (result.next()) {
                if (result.getBoolean("active") == true) {
                    Position listing = new Position();
                    listing.setPositionTitle(result.getString("positionTitle"));
                    listing.setPositionDescription(result.getString("positionDesc"));
                    listing.setPositionPay(result.getString("positionPay"));
                    listing.setPositionSponsor(result.getInt("positionSponsor"));
                    listing.setPositionAddress(result.getString("positionAddress"));
                    listing.setPositionRemote(result.getBoolean("remote"));
                    listing.setPositionActive(result.getBoolean("active"));
                    alJobs.add(listing);
                    items.add(listing.positionTitle);
                }
            }
        } catch (SQLException except) {
            System.out.println("BROKEN HANDLE LOAD");
            except.printStackTrace();
        }
    }
}
