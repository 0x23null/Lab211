package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Lớp tiện ích để thiết lập kết nối đến SQL Server
public class DBConnect {
    
    // THAY ĐỔI CÁC THÔNG SỐ NÀY ĐỂ PHÙ HỢP VỚI MÁY CỦA BẠN
    private static final String USER = "sa"; 
    private static final String PASS = "2355"; 
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Lab211_RV3;encrypt=true;trustServerCertificate=true";
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public static Connection getConnection() {
        try {
            // Đăng ký Driver
            Class.forName(DRIVER);
            // Thiết lập kết nối
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR: SQL Server JDBC Driver not found.");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.err.println("ERROR: Connection failed. Check database server status and credentials.");
            e.printStackTrace();
            return null;
        }
    }
}