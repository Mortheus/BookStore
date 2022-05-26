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
import org.fis.bookstore.exceptions.UserNotFoundException;
import org.fis.bookstore.models.Book;
import org.fis.bookstore.models.Comanda;
import org.fis.bookstore.models.User;
import org.fis.bookstore.services.BookService;
import org.fis.bookstore.services.CartService;
import org.fis.bookstore.services.ComandaService;
import org.fis.bookstore.services.UserService;

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
    private TextField username;
    @FXML
    private Text mesaj;
    @FXML
    private Button butonShoppingCart;
    @FXML
    private Button butonPastOrders;
    @FXML
    private Button emptyCart;
    @FXML
    private Button placeOrder;
    @FXML
    private User user;
    @FXML
    private Label total;
    private static ArrayList<Book> cos;
    private static int t;


    @FXML
    public void handleShoppingCart(){
        try {
            Stage stage = (Stage) butonShoppingCart.getScene().getWindow();
            Parent registerRoot = FXMLLoader.load(getClass().getResource("/ShoppingCart.fxml"));
            Scene scene = new Scene(registerRoot, 640, 480);
            stage.setTitle("Book Store - Home page for client");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handlePastOrders(){
        try {
            Stage stage = (Stage) butonPastOrders.getScene().getWindow();
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/login.fxml"));
            Scene scene = new Scene(loginRoot, 640, 480);
            stage.setTitle("Book Store -login");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleEmptyCart(){
        try {
            Stage stage = (Stage) emptyCart.getScene().getWindow();
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/HomepageClient.fxml"));
            Scene scene = new Scene(loginRoot, 640, 480);
            stage.setTitle("Book Store - Homepage Client");
            stage.setScene(scene);
            CartService.golireCos();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handlePlaceOrder(){
        try {
            User s = UserService.getUser(username.getText());
            Comanda p=new Comanda(nrTel.getText(),adresa.getText(),username.getText(),"Pending",s.getBooks());
            s.addComanda(p);
            p.setBook(s.getBooks());
            for(Comanda c : s.getComenzi()) {
                System.out.println(c);
            }
        }catch( UserNotFoundException e){
            mesaj.setText("nu a fost gasit user");
            return;
        }

        mesaj.setText("Ordered placed with success!");
    }
}
