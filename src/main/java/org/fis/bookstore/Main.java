package org.fis.bookstore;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.fis.bookstore.models.User;
import org.fis.bookstore.services.FileSystemService;
import org.fis.bookstore.services.UserService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main extends Application {
    private static User user;

    @Override

    public void start(Stage stage) throws Exception {
        initDirectory();
        UserService.initDatabase();
       // Comandaservice.initDatabase();
        //BookService.initDatabase();
        Parent root = FXMLLoader.load(getClass().getResource("/login.fxml"));
        stage.setTitle("Book Store - Registration");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public static User getUser(){
        return user;
    }
    public static void setUser(User user){
        Main.user=user;
    }


    private void initDirectory() {
        Path applicationHomePath = FileSystemService.APPLICATION_HOME_PATH;
        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();
    }



    public static void main(String[] args) {
        launch();
    }
}
