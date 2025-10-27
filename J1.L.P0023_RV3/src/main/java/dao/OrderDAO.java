package dao;

import model.Order;
import java.sql.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class OrderDAO {
    
    // Ghi đơn hàng vào bảng CustomerOrder và trả về OrderId
    public int createCustomerOrder(Connection con, String customerName) throws SQLException {
        String sql = "INSERT INTO CustomerOrder (CustomerName, OrderDate) VALUES (?, GETDATE())";
        // Yêu cầu trả về khóa tự tăng (OrderId)
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, customerName);
            ps.executeUpdate();
            
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1); // Trả về OrderId
                }
            }
            throw new SQLException("Failed to retrieve auto-generated OrderId.");
        }
    }

    // Ghi chi tiết từng mặt hàng vào bảng OrderDetail
    public void addOrderDetail(Connection con, int orderId, Order item) throws SQLException {
        String sql = "INSERT INTO OrderDetail (OrderId, FruitId, QuantitySold, ItemPrice) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, orderId);
            ps.setString(2, item.getFruitId());
            ps.setInt(3, item.getQuantity());
            ps.setDouble(4, item.getPrice());
            ps.executeUpdate();
        }
    }

    // Lấy tất cả đơn hàng đã lưu (thay thế cho View Orders từ Hashtable)
    // Giả sử: ht là Map<CustomerName, List<Order>>
    public Map<String, ArrayList<Order>> getAllOrders(Connection con) throws SQLException {
        Map<String, ArrayList<Order>> ordersMap = new Hashtable<>();
        // Câu lệnh SQL JOIN 3 bảng để lấy thông tin chi tiết từng đơn hàng theo tên khách hàng
        String sql = "SELECT co.CustomerName, f.FruitName, od.QuantitySold, od.ItemPrice, f.FruitId " +
                     "FROM CustomerOrder co " +
                     "JOIN OrderDetail od ON co.OrderId = od.OrderId " +
                     "JOIN Fruit f ON od.FruitId = f.FruitId " +
                     "ORDER BY co.OrderDate DESC, co.CustomerName";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
             
            while (rs.next()) {
                String name = rs.getString("CustomerName");
                Order orderItem = new Order(
                    rs.getString("FruitId"),
                    rs.getString("FruitName"),
                    rs.getInt("QuantitySold"),
                    rs.getDouble("ItemPrice")
                );

                // Thêm orderItem vào danh sách của khách hàng tương ứng
                ordersMap.computeIfAbsent(name, k -> new ArrayList<>()).add(orderItem);
            }
        }
        return ordersMap;
    }
}