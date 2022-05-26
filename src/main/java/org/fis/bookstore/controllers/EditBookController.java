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
import org.fis.bookstore.exceptions.BookNotFoundException;
import org.fis.bookstore.models.Book;
import org.fis.bookstore.models.User;
import org.fis.bookstore.services.BookService;
import org.fis.bookstore.services.CartService;

import java.io.IOException;
import java.util.ArrayList;

import static org.fis.bookstore.services.BookService.managerRemoveBook;
import static org.fis.bookstore.services.BookService.managerUpdateBook;

public class EditBookController {
    @FXML
    private TextField bookname;
    @FXML
    private TextField price;
    @FXML
    private TextField quantity;
    @FXML
    private Button update;
    @FXML
    private Button homepage;
    @FXML
    private Text mesaj;


    @FXML
    public void handleHomepage(){
        try {
            Stage stage = (Stage) homepage.getScene().getWindow();
            Parent registerRoot = FXMLLoader.load(getClass().getResource("/HomepageManager.fxml"));
            Scene scene = new Scene(registerRoot, 640, 480);
            stage.setTitle("Book Store - Home page for manager");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void handleUpdate(){
        try {
            if (BookService.getBook(bookname.getText())!= null) {
                Book p = BookService.getBook(bookname.getText());
                int n = Integer.parseInt(price.getText());
                p.setPret(n);
                p.setCantitate(Integer.parseInt(quantity.getText()));
                managerUpdateBook(p);

            }
            mesaj.setText("Book successfully updated");
        } catch (BookNotFoundException e) {
            return;
        }
    }
}
