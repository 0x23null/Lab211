package main.sql_lab211;

public class Book {

    private String isbn;
    private String title;

    @Override
    public String toString() {
        return "Book{"
                + "íbn='" + isbn + '\''
                + ", title='" + title + '\''
                + '}';
    }

    public String getisbn() {
        return isbn;
    }

    public void setÍbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }
}
