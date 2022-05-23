package org.fis.bookstore.models;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Comanda {

    private String nrTel;
    private String adresa;
    private String username;
    private String status;
    private ArrayList<Book> listbooks;


    public Comanda(String nrTel, String adresa,String username, String status,ArrayList<Book> listbooks)
    {
        this.nrTel =nrTel;
        this.adresa=adresa;
        this.username=username;
        this.listbooks=listbooks;
        this.status=status;

    }

    public void setClient(String client) {
        this.username = username;
    }

    public String getClient(){
        return username;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
    public void setBook( ArrayList<Book> listaplante)
    {
        this.listbooks=listbooks;
    }
    public void setNrTel(String nrTel) {
        this.nrTel = nrTel;
    }

    public String getNrTel() {
        return nrTel;
    }


}