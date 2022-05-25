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
import org.fis.bookstore.models.Book;
import org.fis.bookstore.models.User;
import org.fis.bookstore.services.CartService;

import java.io.IOException;
import java.util.ArrayList;

public class ShoppingCartController {
    @FXML
    private Button butonLogOut;
    @FXML
    private Button butonHomepageClient;
    @FXML
    private TextField nrTel;
    @FXML
    private TextArea adresa;
    @FXML
    private TextArea ListaProduse;
    @FXML
    private Text mesaj;
    @FXML
    private User user;
    @FXML
    private Text total;
    private static int t=0;
    private ArrayList<Book> cos;

    @FXML
    private void handleHomepageClient(){
        try {
            Stage stage = (Stage) butonHomepageClient.getScene().getWindow();
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/HomepageClient.fxml"));
            Scene scene = new Scene(loginRoot, 640, 480);
            stage.setTitle("Book Store - Homepage Client");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void initialize(){
        String s="  Nume                         Autor                         Cantitate                         Pret \n";
        cos = CartService.getCos();
        for(Book book:cos){
            t=t+book.getPret()*book.getCantitate();
            s=s+book.getAutor()+"                         "+book.getNume()+"                         "+"            "+book.getCantitate()+ "                         " + book.getPret()+ " \n";
        }
        ListaProduse.setText(s);
        total.setText(t+" lei");
    }

    @FXML
    public void placeOrder() {
        try {
            Stage stage = (Stage) butonLogOut.getScene().getWindow();
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/PlaceOrder.fxml"));
            Scene scene = new Scene(loginRoot, 640, 480);
            stage.setTitle("Plant Store -PlaceOrder");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
