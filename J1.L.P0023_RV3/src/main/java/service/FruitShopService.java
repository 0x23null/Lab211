package service;

import dao.FruitDAO;
import dao.OrderDAO;
import db.DBConnect;
import model.Fruit;
import model.Order;
import model.Validation;
import view.Display;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

// Đây là lớp Service mới thay thế cho FruitShopManager để quản lý logic
public class FruitShopService {

    private final FruitDAO fruitDAO = new FruitDAO();
    private final OrderDAO orderDAO = new OrderDAO();
    private final Display display = new Display();

    // PUBLIC: Entry point for Controller
    public void run() {
        while (true) {
            int opt = display.showMenu();
            switch (opt) {
                case 1 -> createFruit();
                case 2 -> viewOrder();
                case 3 -> shopping();
                case 4 -> {
                    System.out.println("Thank you for using FRUIT SHOP SYSTEM!");
                    return;
                }
            }
        }
    }

    // PRIVATE: 1. Create Fruit - Gọi DAO để lưu vào DB
    private void createFruit() {
        while (true) {
            System.out.print("Enter fruit id: ");
            String fruitId = Validation.checkInputString();

            if (fruitDAO.isIdExist(fruitId)) {
                System.err.println("Id exist. Please enter a unique ID.");
                continue; 
            }
            
            System.out.print("Enter fruit name: ");
            String fruitName = Validation.checkInputString();
            System.out.print("Enter price: ");
            double price = Validation.checkInputDouble();
            System.out.print("Enter quantity: ");
            int quantity = Validation.checkInputInt();
            System.out.print("Enter origin: ");
            String origin = Validation.checkInputString();
            
            Fruit newFruit = new Fruit(fruitId, fruitName, price, quantity, origin);
            if(fruitDAO.insertFruit(newFruit)) {
                 System.out.println("Fruit created successfully.");
            } else {
                 System.err.println("Failed to save fruit to database.");
            }

            if (!Validation.checkInputYN()) {
                return;
            }
        }
    }

    // PRIVATE: 2. View orders - Gọi DAO để lấy dữ liệu từ DB
    private void viewOrder() {
        try (Connection con = DBConnect.getConnection()){
            if (con == null) return;
            
            // Map này sẽ lưu trữ dữ liệu theo cấu trúc cũ để tái sử dụng hàm hiển thị
            Map<String, ArrayList<Order>> allOrders = orderDAO.getAllOrders(con);
            
            if (allOrders.isEmpty()) {
                System.out.println("No orders have been placed yet.");
                return;
            }
            
            for (String name : allOrders.keySet()) {
                System.out.println("Customer: " + name);
                ArrayList<Order> lo = allOrders.get(name);
                displayListOrder(lo);
            }
        } catch (SQLException e) {
             System.err.println("Error viewing orders: " + e.getMessage());
        }
    }

    // PRIVATE: 3. Shopping - Logic Giao dịch (Transaction Logic)
    private void shopping() {
        List<Fruit> availableFruits = fruitDAO.getAllFruitsInStock();
        if (availableFruits.isEmpty()) {
            System.err.println("No items available in stock.");
            return;
        }

        ArrayList<Order> currentOrderList = new ArrayList<>();
        
        while (true) {
            displayListFruit(availableFruits);
            
            if (!currentOrderList.isEmpty()) {
                System.out.println("Current Cart:");
                displayListOrder(currentOrderList);
            }
            
            System.out.print("Enter item: ");
            int itemIndex = Validation.checkInputIntLimit(1, availableFruits.size());
            
            Fruit fruit = availableFruits.get(itemIndex - 1); // Lấy Fruit từ list hiển thị
            
            System.out.print("Enter quantity: ");
            int quantity = Validation.checkInputIntLimit(1, fruit.getQuantity()); 
            
            // Cập nhật giỏ hàng tạm thời
            if (!Validation.checkItemExist(currentOrderList, fruit.getFruitId())) {
                updateOrder(currentOrderList, fruit.getFruitId(), quantity);
            } else {
                currentOrderList.add(new Order(
                    fruit.getFruitId(), 
                    fruit.getFruitName(),
                    quantity, 
                    fruit.getPrice()
                ));
            }
            
            // Hỏi khách hàng có muốn đặt hàng ngay không
            if (!Validation.checkInputYN()) {
                continue; // Tiếp tục mua sắm
            }
            
            // --- XỬ LÝ GIAO DỊCH (TRANSACTION) VỚI DB ---
            processTransaction(currentOrderList);
            return; 
        }
    }
    
    // Logic Giao dịch: Đảm bảo tất cả các bước (ghi order, ghi chi tiết, trừ kho) thành công
    private void processTransaction(ArrayList<Order> currentOrderList) {
        Connection con = null;
        try {
            con = DBConnect.getConnection();
            if (con == null) return;

            // Bắt đầu giao dịch: Vô hiệu hóa auto-commit
            con.setAutoCommit(false); 

            displayListOrder(currentOrderList);
            System.out.print("Input your name: ");
            String name = Validation.checkInputString();
            
            // 1. Ghi Order Header và lấy OrderId
            int orderId = orderDAO.createCustomerOrder(con, name);
            
            // 2. Ghi Order Details và Trừ tồn kho (tại thời điểm này)
            for(Order item : currentOrderList) {
                // Ghi chi tiết
                orderDAO.addOrderDetail(con, orderId, item); 
                
                // Trừ tồn kho (sử dụng connection của transaction)
                fruitDAO.updateStock(con, item.getFruitId(), -item.getQuantity()); 
            }
            
            // 3. Kết thúc giao dịch
            con.commit();
            System.out.println("Order added successfully for customer: " + name);

        } catch (SQLException e) {
            try {
                if (con != null) con.rollback(); // Hoàn tác nếu có lỗi
            } catch (SQLException ex) {
                System.err.println("Rollback failed: " + ex.getMessage());
            }
            System.err.println("Transaction failed. Changes reverted. Error: " + e.getMessage());
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                // ignore
            }
        }
    }

    // Hàm hỗ trợ hiển thị danh sách trái cây
    private void displayListFruit(List<Fruit> lf) {
        // ... (Logic tương tự như trong file đã sửa đổi)
    }

    // Hàm hỗ trợ hiển thị chi tiết đơn hàng
    private void displayListOrder(ArrayList<Order> lo) {
        // ... (Logic tương tự như trong file đã sửa đổi)
    }

    // Hàm hỗ trợ cập nhật số lượng trong giỏ hàng tạm thời
    private void updateOrder(ArrayList<Order> lo, String id, int quantity) {
        // ... (Logic tương tự như trong file đã sửa đổi)
    }
}