package org.fis.bookstore.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.fis.bookstore.Main;
import org.fis.bookstore.exceptions.UserNotFoundException;
import org.fis.bookstore.models.User;
import org.fis.bookstore.services.UserService;

import java.io.IOException;

public class LoggedInController {

    @FXML
    public Text loginMessage;
    @FXML
    public PasswordField passwordField;
    @FXML
    public TextField usernameField;

    @FXML
    public void handleLoginAction() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username == null || username.isEmpty()) {
            loginMessage.setText("Please type in a username!");
            return;
        }

        if (password == null || password.isEmpty()) {
            loginMessage.setText("Password cannot be empty");
            return;
        }

        String encoded_password = UserService.encodePassword(username, password);

        try{

            String stored_password = UserService.getHashedUserPassword(username);
            if(stored_password.equals(encoded_password)){
                Main.setUser(UserService.getUser(username));
                if(UserService.getUser(username).getRole().equals("Client")){
                    HomepageClient();
                    return;
                }
                if(UserService.getUser(username).getRole().equals("Manager")){
                    HomepageManager();
                    return;
                }
            }

        } catch( UserNotFoundException e){
            loginMessage.setText(e.getMessage());
            return;
        }

        loginMessage.setText("Incorrect login!");
    }

    @FXML
    public void loadRegisterPage(){
        try {
            Stage stage = (Stage) loginMessage.getScene().getWindow();
            Parent registerRoot = FXMLLoader.load(getClass().getResource("/sign-up.fxml"));
            Scene scene = new Scene(registerRoot, 600, 400);
            stage.setTitle("Book Store - Register");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void HomepageClient(){
        try {
            Stage stage = (Stage) loginMessage.getScene().getWindow();
            Parent registerRoot = FXMLLoader.load(getClass().getResource("/HomepageClient.fxml"));
            Scene scene = new Scene(registerRoot, 600, 400);
            stage.setTitle("Book Store - Home page for client");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void HomepageManager(){
        try {
            Stage stage = (Stage) loginMessage.getScene().getWindow();
            Parent registerRoot = FXMLLoader.load(getClass().getResource("/HomepageManager.fxml"));
            Scene scene = new Scene(registerRoot, 600, 400);
            stage.setTitle("Book Store - Home page for manager");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}