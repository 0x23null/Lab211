package dao;

import db.DBConnect;
import model.Fruit;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FruitDAO {
    
    public List<Fruit> getAllFruitsInStock() {
        List<Fruit> list = new ArrayList<>();
        String sql = "SELECT * FROM Fruit WHERE QuantityInStock > 0";
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
             
            while (rs.next()) {
                Fruit f = new Fruit(
                    rs.getString("FruitId"),
                    rs.getString("FruitName"),
                    rs.getDouble("Price"),
                    rs.getInt("QuantityInStock"),
                    rs.getString("Origin")
                );
                list.add(f);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching fruit list: " + e.getMessage());
        }
        return list;
    }

    public boolean isIdExist(String fruitId) {
        String sql = "SELECT 1 FROM Fruit WHERE FruitId = ?";
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setString(1, fruitId);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next(); // True nếu tồn tại
            }
        } catch (SQLException e) {
            System.err.println("Error checking Fruit ID: " + e.getMessage());
            return true;
        }
    }

    public boolean insertFruit(Fruit f) {
        String sql = "INSERT INTO Fruit (FruitId, FruitName, Price, QuantityInStock, Origin) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setString(1, f.getFruitId());
            ps.setString(2, f.getFruitName());
            ps.setDouble(3, f.getPrice());
            ps.setInt(4, f.getQuantity());
            ps.setString(5, f.getOrigin());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error inserting new fruit: " + e.getMessage());
            return false;
        }
    }

    public void updateStock(Connection con, String fruitId, int quantityChange) throws SQLException {
        String sql = "UPDATE Fruit SET QuantityInStock = QuantityInStock + ? WHERE FruitId = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, quantityChange); 
            ps.setString(2, fruitId);
            ps.executeUpdate();
        }
    }
}