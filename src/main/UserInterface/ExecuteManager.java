package main.UserInterface;

import main.Book.Publisher;
import main.Book.Book;
import java.util.Scanner;


public class ExecuteManager {
    private final Scanner in;
    private final Publisher publisher;

    public ExecuteManager(Publisher publisher) {
        this.publisher = publisher;
        in = new Scanner(System.in);
    }

    public void addBook() {
        try {
            System.out.print(" Название:\t");
            String name = in.nextLine();

            System.out.print(" Автор:\t");
            String author = in.nextLine();

            System.out.print(" Издательство:\t");
            String tempPublisher= in.nextLine();

            System.out.print(" Год издания:\t");
            int year = in.nextInt();

            System.out.print(" Количество страниц:\t");
            int pages = in.nextInt();

            System.out.print(" Цена:\t");
            int price = in.nextInt();
            in.nextLine();

            publisher.addBook(name, tempPublisher, author, year, pages, price);
        } catch (Exception e) {
            System.err.println("Ошибка ввода");
        }
    }
    public void deleteBook(int id) {
        publisher.deleteBook(id);
    }
}
