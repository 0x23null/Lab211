package main.sql_lab211;

public class SQL_LAB211 {

    public static void main(String[] args) {
        BookDao bd = new BookDao();
        bd.addBook(new Book("2312", "CSharp"));
        Book bb = bd.findAbook("2312");
        if (bb != null) {
            System.out.println("Found: " + bb.toString());
        }
    }
}
