package main.sql_lab211;

public class SQL_LAB211 {

    public static void main(String[] args) {
        if (DBConnect.getConnection() != null) {
            System.out.println("TCong");
        }
    }
}
