package com.group.job_board;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author George, Timmothy
 */
public class FirestoreContext {

    /**
     * Create a connection to the database.
     *
     * @return the Firestore object that acts as the connection.
     */
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

    /**
     * Logs a user in by setting the app's global user variable to a new user
     * with their info.
     *
     * @param email email login
     * @param password password login
     */
    public static void login(String email, String password) {
        try {
            CollectionReference userTable = App.fStore.collection("Users");
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
            }
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(FirestoreContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean userExists(String email, String password) throws InterruptedException, ExecutionException {
        CollectionReference userTable = App.fStore.collection("Users");
        Query emailPassMatch = userTable.whereEqualTo("email", email).whereEqualTo("password", password);
        ApiFuture<QuerySnapshot> qsnapshot = emailPassMatch.get();
        return !qsnapshot.get().getDocuments().isEmpty();
    }

    /**
     * Logs user out.
     */
    public static void logout() {
        App.currentUser = null;
    }

    /**
     * Account creation for users.
     *
     * @param map Map of user data being added
     */
    public static void addUser(Map<String, String> map) {
        App.fStore.collection("Users").document(map.get("username")).set(map);
    }

    /**
     * Creation of a new job posting.
     *
     * @param p job posting object with info to be added into the database.
     */
    public static void addJobPosting(Position p) {
        try {
            ApiFuture<WriteResult> future = App.fStore.collection("JobPostings").document().set(p);
            System.out.println("Update time : " + future.get().getUpdateTime());
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(FirestoreContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Removes an existing job posting from the database.
     *
     * @param jobID ID number to identify the job that will be removed.
     */
    public static void removeJobPosting(int jobID) {
        try {
            CollectionReference userTable = App.fStore.collection("JobPostings");
            Query jobIDMatch = userTable.whereEqualTo("jobID", jobID);
            ApiFuture<QuerySnapshot> qsnapshot = jobIDMatch.get();
            for (DocumentSnapshot doc : qsnapshot.get().getDocuments()) {
                doc.getReference().delete();
                System.out.printf("Job posting %d has been successfully deleted.\n", jobID);
            }
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(FirestoreContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Search through database and find user with this username and delete them.
     *
     * @param username username of user being deleted.
     */
    public static void removeUser(String username) {
        try {
            CollectionReference userTable = App.fStore.collection("Users");
            Query usernameMatch = userTable.whereEqualTo("username", username);
            ApiFuture<QuerySnapshot> qsnapshot = usernameMatch.get();
            for (DocumentSnapshot doc : qsnapshot.get().getDocuments()) {
                doc.getReference().delete();
                System.out.printf("User %s has been successfully deleted.\n", username);
            }
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(FirestoreContext.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}
