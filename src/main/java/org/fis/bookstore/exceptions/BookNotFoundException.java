package org.fis.bookstore.exceptions;

public class BookNotFoundException extends Throwable{
    private String name;
    public BookNotFoundException(String name) {
        super(String.format("The book does not exist !", name));
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
