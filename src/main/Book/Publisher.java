package main.Book;

import main.Utilities.FileExecutor;

import java.util.*;

public class Publisher {
    private final List<Book> books;
    private final Set<String> publishers;
    private final Map<String, ArrayList<Book>> publishersAndBooks;
    private final Filter filter;

    public Publisher() {
        books = new ArrayList<>(FileExecutor.readFile());
        publishers = new HashSet<>();
        publishersAndBooks = new HashMap<>();
        filter = new Filter(books);

        update();
        initBookId();
    }

    public void addBook(String name, String publisher, String author, int year, int pages, int price) {
        books.add(new Book(name, publisher, author, year, pages, price));
        save();
        update();
    }

    public void deleteBook(int id) {
        books.removeIf(s -> s.getId() == id);
        FileExecutor.deleteBook(id);
        update();
        save();
    }

    private void initBookId() {
        try {
              Book.setCountOfBook(
                    books.stream().max(
                            Comparator.comparing(Book::getId)).get().getId());
        } catch (NoSuchElementException ignored) {
            // ignored
        }
    }

    private void update() {
        searchPublisher();
        searchPublisherWithBooks();
    }

    private void searchPublisher() {
        for (Book book : books) {
            publishers.add(book.getPublisher());
        }
    }

    private void searchPublisherWithBooks() {
        publishersAndBooks.clear();
        for (Book book : books) {
            publishersAndBooks.put(book.getPublisher(), searchBooks(book.getPublisher()));
        }
    }

    private ArrayList<Book> searchBooks(String publisherName) {
        ArrayList<Book> filterBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getPublisher().equals(publisherName)) {
                filterBooks.add(book);
            }
        }
        return filterBooks;
    }

    private void save() {
        FileExecutor.saveBooksToFile(books);
    }

    public List<Book> getBooks() {
        return books;
    }

    //a
    public List<Book> byAuthor(String author) {
        return filter.byAuthor(author);
    }
    //b
    public List<Book> byPublisher(String publisher) {
        return filter.byPublisher(publisher);
    }
    //c
    public List<Book> afterYear(int year) {
        return filter.afterYear(year);
    }
    //d
    public List<Book> byAlphabet() {
        return filter.byAlphabet();
    }
    //e
    public Set<String> getPublishers() {
        return publishers;
    }
    // f
    public Map<String, ArrayList<Book>> getPublishersAndBooks() {
        return filter.getPublishersAndBooks();
    }
}