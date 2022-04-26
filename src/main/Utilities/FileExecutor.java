package main.Utilities;

import main.Book.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileExecutor {
    private final static String FILE_PATH = "file.path";

    private FileExecutor() {  }

    public static ArrayList<Book> readFile() {
        ArrayList<Book> bookList = new ArrayList<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(PropertiesUtil.get(FILE_PATH))))
        {
            bookList = (ArrayList<Book>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(PropertiesUtil.get(FILE_PATH)))) {

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }


        return bookList;
    }

    public static void saveBooksToFile(List<Book> books) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(PropertiesUtil.get(FILE_PATH)))) {
            out.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteBook(int id) {
        var items = readFile();
        items.removeIf(s -> s.getId() == id);

        final String SECOND_FILE = "book.dat";

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(SECOND_FILE))) {
            out.writeObject(items);
            File mainlyFile = new File(PropertiesUtil.get(FILE_PATH));
            mainlyFile.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File secondFile = new File(SECOND_FILE);
        File newFile = new File(PropertiesUtil.get(FILE_PATH));

        secondFile.renameTo(newFile);
    }
}
