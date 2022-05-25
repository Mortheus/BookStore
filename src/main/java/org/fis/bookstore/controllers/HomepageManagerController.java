package org.fis.bookstore.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.fis.bookstore.Main;
import org.fis.bookstore.exceptions.BookNotFoundException;
import org.fis.bookstore.models.Book;
import org.fis.bookstore.models.User;
import org.fis.bookstore.services.BookService;

import java.io.IOException;
import java.util.ArrayList;

import static org.fis.bookstore.services.BookService.managerRemoveBook;

public class HomepageManagerController {
    @FXML
    private Button butonLogOut;
    @FXML
    private Button butonAddedPlants;
    @FXML
    private Button butonAddPlant;
    @FXML
    private Text mesaj;
    @FXML
    private TextField BookName;
    @FXML
    private TextField Price;
    @FXML
    private TextField AutorName;
    @FXML
    private TextField Quantity;
    @FXML
    private User user;

    public void setUser(User user)
    {

        this.user=user;
    }

    @FXML
    private void handleAddBook()  {

        Book p=new Book(BookName.getText(),AutorName.getText(), Integer.parseInt(Price.getText()),Integer.parseInt(Quantity.getText()));
        BookService.managerAddBook(p);
        System.out.println(p.toString());
        BookName.setText("");
        AutorName.setText("");
        Price.setText("");
        Quantity.setText("");


        mesaj.setText("Cartea a fost adaugata cu succes!");
    }
    @FXML
    private void removeBook() {
        try {
            if (BookService.getBook(BookName.getText())!= null) {
                Book p = BookService.getBook(BookName.getText());
                managerRemoveBook(p);

            }
            mesaj.setText("Cartea a fost eliminata cu succes!");
        } catch (BookNotFoundException e) {
            return;
        }

    }
    @FXML

    private void handleLoginAction() {
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
