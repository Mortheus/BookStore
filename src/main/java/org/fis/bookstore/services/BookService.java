package org.fis.bookstore.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.Cursor;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;
import org.fis.bookstore.exceptions.BookNotFoundException;
import org.fis.bookstore.models.Book;

import java.util.ArrayList;
import java.util.List;

import static org.fis.bookstore.services.FileSystemService.getPathToFile;

public class BookService {


    private static ObjectRepository<Book> BookRepository;


    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("Books.db").toFile())
                .openOrCreate("test", "test");
        BookRepository = database.getRepository(Book.class);

    }

    public static void managerAddBook(Book book) {
        BookRepository.insert(book);
    }

    public static Book getBook(String nume) throws BookNotFoundException {
        Cursor<Book> cursor = BookRepository.find(ObjectFilters.eq("nume", nume));
        for (Book b : cursor){
            return b;
        }
        throw new BookNotFoundException(nume);
    }


    public static void managerRemoveBook(Book book){
        BookRepository.remove(book);
    }


    public static ArrayList<Book> getAllBooks() {

        ArrayList<Book> result = new ArrayList<>();
        for(Book b : BookRepository.find()){
            result.add(b);
        }

        return result;
    }


}
