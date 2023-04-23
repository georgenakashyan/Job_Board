package com.group.job_board;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.auth.internal.GetAccountInfoResponse.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static Firestore fStore;
    public static Users currentUser;

    @Override
    public void start(Stage stage) throws IOException {
        FirestoreContext fs = new FirestoreContext();
        fStore =  fs.connectToDB();
        scene = new Scene(loadFXML("LoginMenu"), 640, 480);
        stage.setScene(scene);
        stage.show();
        //stage.setResizable(false);
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}