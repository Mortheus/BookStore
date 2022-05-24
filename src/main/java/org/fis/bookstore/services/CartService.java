package org.fis.bookstore.services;

import org.fis.bookstore.models.Book;

import java.util.ArrayList;

public class CartService {

    public static ArrayList<Book> cosCumparaturi= new ArrayList<Book>();
    public static ArrayList<Book> cosBookStore= new ArrayList<Book>();

    public static ArrayList<Book> getCos() {
        return cosCumparaturi;
    }

    public static void setCosCumparaturi(ArrayList<Book> cosCumparaturi) {
        CartService.cosCumparaturi = cosCumparaturi;
    }
    public static void addCos(Book b){
        cosCumparaturi.add(b);
    }
    public static void golireCos()
    {
        cosCumparaturi.clear();
    }

    public static ArrayList<Book> getCosBookStore() {
        return cosCumparaturi;
    }

    public static void setCosBookStore(ArrayList<Book> cosCumparaturi) {
        CartService.cosCumparaturi = cosCumparaturi;
    }
}
