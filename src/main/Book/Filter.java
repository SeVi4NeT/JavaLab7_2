package main.Book;

import java.util.*;

public class Filter {
    private final List<Book> books;

    public Filter(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    //a
    public List<Book> byAuthor(String author) { //by author
        List<Book> a = new ArrayList<>();
        for (Book book : books) {
            if (Objects.equals(book.getAuthor(), author)) {
                a.add(book);
            }
            a.sort(Comparator.comparing(Book::getYear));
        }
        return a;
    }

    //b
    public List<Book> byPublisher(String publisher) { //by publisher
        List<Book> b = new ArrayList<>();
        for (Book book : books) {
            if (Objects.equals(book.getPublisher(), publisher)) {
                b.add(book);
            }
        }
        return b;
    }

    //c
    public List<Book> afterYear(int year) { //by year
        List<Book> c = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() >= year) {
                c.add(book);
            }
        }
        return c;
    }

    //d
    public List<Book> byAlphabet() {
        List<Book> d = new ArrayList<>(books);
        d.sort(Comparator.comparing(Book::getAuthor));
        return d;
    }


    //e логика отсуствует


    //f

}