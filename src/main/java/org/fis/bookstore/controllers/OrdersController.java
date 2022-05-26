package org.fis.bookstore.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.fis.bookstore.models.Book;
import org.fis.bookstore.services.UserService;

import java.io.IOException;
import java.util.ArrayList;

public class OrdersController {
    @FXML
    private Button homepage;
    @FXML
    private Button update;
    @FXML
    private ChoiceBox status;
    @FXML
    private TextField client;


    private ArrayList<Book> orders;

    /*@FXML
    public void initialize() {
        status.getItems().addAll("Delivered");
    }
    */
    @FXML
    private void handleHomepageAction() {
        try {
            Stage stage = (Stage) homepage.getScene().getWindow();
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/HomepageManager.fxml"));
            Scene scene = new Scene(loginRoot, 640, 480);
            stage.setTitle("Book Store -login");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
