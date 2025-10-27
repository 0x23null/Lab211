package main.sql_lab211;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    static String user = "sa";
    static String pass = "2355";
    static String url = "jdbc:sqlserver://localhost:1433;databaseName=Lab211_RV3;encrypt=true;trustServerCertificate=true";
    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public static Connection getConnection() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("loi connect : " + e.getMessage());
            return null;
        }
    }

}
