package main.sql_lab211;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDao {

    public int addBook(Book b) {
        int row = 0;
        String sql = "insert into Book(isbn,title) values(?,?)";
        Connection con = null;
        try {
            con = DBConnect.getConnection();
            con.setAutoCommit(false);
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, b.getisbn());
            pre.setString(2, b.getTitle());
            row = pre.executeUpdate();
            con.commit();
            return row;
        } catch (SQLException e) {
            System.out.println("loi add: " + e.getMessage());
            try {
                con.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            return row;
        }
    }

    public Book findAbook(String id) {
        Book b = null;
        String sql = "select * from Book where isbn = ?";
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, id);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                return new Book(rs.getString(1), rs.getString(2));
            }
        } catch (SQLException e) {
            System.out.println("loi find : " + e.getMessage());
        }
        return b;
    }
}
