package com.group.job_board;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MoaathAlrajab
 */
public class FirestoreContext {

    public static Firestore connectToDB() {
        try {
            FileInputStream serviceAccount = new FileInputStream("key.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://jobboard-csc325-default-rtdb.firebaseio.com")
                    .build();
            FirebaseApp.initializeApp(options);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return FirestoreClient.getFirestore();
    }

    public static void login(String email, String password) {
        try {
            CollectionReference userTable = App.fStore.collection("Users");
            FirebaseAuth auth = FirebaseAuth.getInstance();
            Query emailPassMatch = userTable.whereEqualTo("email", email).whereEqualTo("password", password);
            ApiFuture<QuerySnapshot> qsnapshot = emailPassMatch.get();
            for (DocumentSnapshot doc : qsnapshot.get().getDocuments()) {
                switch (doc.getString("accountType")) {
                    case "Applicant":
                        App.currentUser = doc.toObject(Applicant.class);
                        break;
                    case "Employer":
                        App.currentUser = doc.toObject(Employer.class);
                        break;
                    case "Moderator":
                        App.currentUser = doc.toObject(Moderator.class);
                        break;
                }
                //Sign in successful, Update GUI
                //Set current user variable.
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(FirestoreContext.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(FirestoreContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void logout() {
        App.currentUser = null;
    }

    /**
     * Account creation for users.
     *
     * @param u Users of which is being added.
     */
    public static void addUser(Users u) {
        switch (u.getClass().getTypeName()) {
            case "Employer":
                Employer emp = (Employer) u;
                break;
            case "Applicant":
                Applicant apl = (Applicant) u;
                break;
            case "Moderator":
                Moderator mod = (Moderator) u;
                break;
        }
    }

    public static void addJobPosting() {

    }

    public static void removeJobPosting() {

    }

    // Moderator commands
    /**
     * Search through database and find user with this username and delete them.
     *
     * @param username username of user being deleted.
     */
    public static void removeUser(String username) {

    }
}
