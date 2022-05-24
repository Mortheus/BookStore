package org.fis.bookstore.models;

public class Book {

    private String nume;
    private String autor;
    private int pret;
    private int cantitate;

    public Book(String nume, String autor, int pret, int cantitate){
        this.nume = nume;
        this.autor = autor;
        this.cantitate = cantitate;
        this.pret = pret;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNume(){
        return nume;

    }

    public void setAutor(){
        this.autor = autor;
    }
    public String getAutor(){
        return autor;
    }

    public void setPret(){
        this.pret = pret;
    }
    public int getPret(){
        return pret;
    }
    public void setCantitate(){
        this.cantitate = cantitate;
    }
    public int getCantitate(){
        return cantitate;
    }

    @Override
    public String toString()
    {
        return "Planta:"+
                "nume " + nume +
                ", autor " + autor +
                ", pret " + pret +
                ", quantity " + cantitate;
    }

}