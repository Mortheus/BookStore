package org.fis.bookstore.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.fis.bookstore.models.Book;
import org.fis.bookstore.models.Comanda;

import java.util.ArrayList;

import static org.fis.bookstore.services.FileSystemService.getPathToFile;


    public class ComandaService {

        private static ObjectRepository<Comanda> comandaRepository;

        private static Nitrite database;
        private ArrayList<Book> booklist;

        public static void initDatabase() {
            Nitrite database = Nitrite.builder()
                    .filePath(getPathToFile("Comanda.db").toFile())
                    .openOrCreate("admin", "admin");
            comandaRepository = database.getRepository(Comanda.class);
        }
        public static Nitrite getDatabase(){
            return database;
        }

        public static void addComanda(Comanda o) {
            comandaRepository.insert(o);
        }


        public static ArrayList<Comanda> getAll(){
            ArrayList<Comanda> result = new ArrayList<>();
            for(Comanda b :  comandaRepository.find()){
                result.add(b);
            }

            return result;
        }
    }

