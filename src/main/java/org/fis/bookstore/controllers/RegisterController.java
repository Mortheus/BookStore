package org.fis.bookstore.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.fis.bookstore.services.UserService;
import org.fis.bookstore.exceptions.UsernameAlreadyExistsException;

import java.io.IOException;

public class RegisterController {

    @FXML
    private Text registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private ChoiceBox role;

    @FXML
    public void initialize() {
        role.getItems().addAll("Manager", "Client");
    }

    @FXML
    public void handleRegisterAction() {
        try {
            if(!usernameField.getText().trim().isEmpty() && !passwordField.getText().trim().isEmpty() && role.getValue() != null) {
                UserService.addUser(usernameField.getText(), passwordField.getText(), (String) role.getValue(), passwordField.getText());
                registrationMessage.setText("Account created successfully!");
            }
            else {
                registrationMessage.setText("Please fill in all information!");
            }
        } catch (UsernameAlreadyExistsException e) {
            registrationMessage.setText(e.getMessage());
        }
    }
    @FXML
    public void loadLoginPage(){
        try {
            Stage stage = (Stage) registrationMessage.getScene().getWindow();
            Parent viewStudentsRoot = FXMLLoader.load(getClass().getResource("/login.fxml"));
            Scene scene = new Scene(viewStudentsRoot, 600, 400);
            stage.setTitle("Book Store - Log in");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
