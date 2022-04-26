package main.Book;
import java.io.Serial;
import java.io.Serializable;

public class Book implements Serializable{
    @Serial
    private static int countBooks = 0;
    private final int id;
    private final String name;
    private final String publisher;
    private final String author;
    private final int year;
    private final int pages;
    private final int price;

    public Book(String name, String publisher, String author, int year, int pages, int price)
    {
        countBooks++;
        this.id = countBooks;
        this.name = name;
        this.publisher = publisher;
        this.author = author;
        this.year = year;
        this.pages = pages;
        this.price = price;
    }
    @Override

    public String toString() {
        return "Book " +
                "id=" + id +
                ", name=" + name +
                ", publisher=" + publisher +
                ", author=" + author +
                ", year=" + year +
                ", pages=" + pages +
                ", price=" + price + '\'' +
                ';';
    }
    public static void setCountOfBook(int count) {
        countBooks = count;
    }

    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getPublisher()
    {
        return publisher;
    }
    public String getAuthor()
    {
        return author;
    }
    public int getYear() {
        return year;
    }
    public int getPages() {
        return pages;
    }
    public int getPrice() {
        return price;
    }

}