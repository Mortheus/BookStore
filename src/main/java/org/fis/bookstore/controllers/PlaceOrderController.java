package org.fis.bookstore.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.fis.bookstore.Main;
import org.fis.bookstore.models.Book;
import org.fis.bookstore.models.User;
import org.fis.bookstore.services.CartService;

import java.io.IOException;
import java.util.ArrayList;

public class PlaceOrderController {

    @FXML
    private TextField nrTel;
    @FXML
    private TextField adresa;
    @FXML
    private TextArea ListaProd;
    @FXML
    private Text mesaj;
    @FXML
    private Button butonLogOut;
    @FXML
    private User user;
    @FXML
    private Label total;
    private static ArrayList<Book> cos;
    private static int t;


    @FXML
    public void handleHomePage(){
        try {
            Stage stage = (Stage) butonLogOut.getScene().getWindow();
            Parent registerRoot = FXMLLoader.load(getClass().getResource("/HomepageClient.fxml"));
            Scene scene = new Scene(registerRoot, 640, 480);
            CartService.golireCos();
            stage.setTitle("Book Store - Home page for client");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void handleCancel(){
        CartService.golireCos();

    }

    @FXML
    private void handleLoginAction(){
        try {
            Stage stage = (Stage) butonLogOut.getScene().getWindow();
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/login.fxml"));
            Scene scene = new Scene(loginRoot, 640, 480);
            stage.setTitle("Book Store -login");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
