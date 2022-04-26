package main.UserInterface;

import main.Book.Publisher;
import main.Book.Book;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Menu {
    private final Publisher publisher;

    public Menu(Publisher publisher) {
        this.publisher = publisher;
    }

    public void showAll() {
        List<Book> books = publisher.getBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    //a
    public void byAuthor(String author) {
        var toShow = publisher.byAuthor(author);

        System.out.println("__________\n" +
                "Список книг автора :  \"" + author + "\", \n");

        for (Book book : toShow) {
            System.out.println("-> " + book + "--");
        }

        System.out.println("__________");
    }

    //b
    public void byPublisher(String name) {
        var toShow = publisher.byPublisher(name);

        System.out.println("__________\n" +
                "Данным издателем: \"" + name + "\", \n");

        for (Book book : toShow) {
            System.out.println("-> " + book + "--");
        }

        System.out.println("__________");
    }

    //c
    public void afterYear(int year) {
        var toShow = publisher.afterYear(year);

        System.out.println("__________\n" +
                "После данной даты \"" + year + "\", \n");

        for (Book book : toShow) {
            System.out.println("-> " + book + "--");
        }

        System.out.println("__________");
    }

    //d
    public void byAlphabet() {
        var toShow = publisher.byAlphabet();

        System.out.println("__________\n" +
                "В алфавитном порядке \""  + "\", \n");

        for (Book book : toShow) {
            System.out.println("-> " + book + "--");
        }

        System.out.println("__________");
    }

    //e zero logic
    public void getPublisher() {
            var toShow = publisher.getPublishers();
            System.out.println("_________\n" +
                    "Все пункты назначения:");

            for (String s : toShow) {
                System.out.println("-> " + s);
            }

            System.out.println("__________");
        }
    //f
   public void getPublishersAndBooks() {
       var toShow = publisher.getPublishersAndBooks();
       ArrayList<Book> mapValue;

       System.out.println("__________");
       for (String s : toShow.keySet()) {
           System.out.println("Издательство: " + s + "\n" +
                   "Книга:");

           mapValue = toShow.get(s);
           for (Book book : mapValue) {
               System.out.print("-> " + book);
           }

           System.out.println("__________");
       }
   }
    public void showMenu() {
        System.out.println("""
                __________
                Меню:
                Показать все книги -- 1                    |
                Добавить книгу -- 2                        |
                Удалить книгу -- 3                         |
                Список книг указанного автора -- a         |
                Список книг указанного издалельства -- b   |
                Список книг после указанного года -- c     |
                Список Авторов в алфавитном порядке -- d   |
                Список издателей -- e                      |
                Список издательст и их книг -- f           |
                __________""");
    }
}

