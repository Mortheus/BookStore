package org.fis.bookstore.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.Cursor;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;
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
}
