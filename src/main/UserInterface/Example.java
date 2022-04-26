package main.UserInterface;

import main.Book.Publisher;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Example {
    private Publisher publisher;
    private ExecuteManager executeManager;
    private Menu menu;

    public Example() {
        publisher = new Publisher();
        executeManager = new ExecuteManager(publisher);
        menu = new Menu(publisher);
    }

    public static void main(String[] args) {
        Example start = new Example();
        start.run();
    }
    private void run() {
        Scanner in = new Scanner(System.in);
        String choice;
        String name;
        int year;

        while (true) {
            menu.showMenu();
            System.out.print("ВЫБОР:\t");
            choice = in.nextLine();

            try {
                switch (choice)
                {
                    case "a":
                        System.out.print("Author:\t");
                        name = in.nextLine();
                        menu.byAuthor(name);
                        choice = "0";
                        break;
                    case "b":
                        System.out.print("Publisher:\t");
                        name = in.nextLine();
                        menu.byPublisher(name);
                        choice = "0";
                        break;
                    case "c":
                        System.out.print("year:\t");
                        year = in.nextInt();
                        menu.afterYear(year);
                        break;
                    case "d":
                        menu.byAlphabet();
                        break;
                    case "e":
                        menu.getPublisher();
                        break;
                    case "f":
                        menu.getPublishersAndBooks();
                        break;
                    case "1":
                        menu.showAll();
                        break;
                    case "2":
                        executeManager.addBook();
                        break;
                    case "3":
                        System.out.print("id:\t");
                        int id = in.nextInt();
                        executeManager.deleteBook(id);
                        break;
                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                choice = "";
                System.out.println("input invalid value");
            }
        }
    }
}


