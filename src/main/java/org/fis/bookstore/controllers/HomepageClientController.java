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
import org.fis.bookstore.exceptions.BookNotFoundException;
import org.fis.bookstore.models.Book;
import org.fis.bookstore.models.User;
import org.fis.bookstore.services.BookService;

import java.io.IOException;
import java.util.ArrayList;

import static org.fis.bookstore.services.CartService.cosCumparaturi;

public class HomepageClientController {
    @FXML
    private Button butonShoppingCart;
    @FXML
    private Button butonLogOut;
    @FXML
    private Text total;
    @FXML
    private TextField idBook;
    @FXML
    private TextField  cantitate;
    private int t=0;
    @FXML
    private User user;

    @FXML
    private Text bookError;




    public void setUser(User user)
    {

        this.user=user;
    }
    @FXML
    private ListView myView;

    /*public void initialize() {
        ArrayList<Book> orders = BookService.getAllBooksShop();
        System.out.println(orders);
        for (Book o : orders) {
            myView.getItems().add(o.toString());
        }

    }*/



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

    @FXML
    private void handleShoppingCart(){
        try {
            Stage stage = (Stage) butonShoppingCart.getScene().getWindow();
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/ShoppingCart.fxml"));
            Scene scene = new Scene(loginRoot, 640, 480);
            stage.setTitle("Book Store - Shopping Cart");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void handleAddToCart() {

        try {

            if(BookService.getBook(idBook.getText()) != null) {
                Book p =(BookService.getBook(idBook.getText()));
                cosCumparaturi.add(new Book(p.getAutor(), p.getNume(),p.getPret(),Integer.parseInt(cantitate.getText())));
                System.out.println(BookService.getBook(idBook.getText()).getNume());
                t=t+BookService.getBook(idBook.getText()).getPret()*Integer.parseInt(cantitate.getText());
                total.setText(String.valueOf(t));
            }

        }
        catch(BookNotFoundException e){
            bookError.setText("Book does not exist!");
            return;
        }
    }
}
