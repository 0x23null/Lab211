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
import java.util.List;
import java.util.Map;

public class FruitShopService {

    private final FruitDAO fruitDAO = new FruitDAO();
    private final OrderDAO orderDAO = new OrderDAO();
    private final Display display = new Display();

    public void run() {
        while (true) {
            int opt = display.showMenu();
            switch (opt) {
                case 1 ->
                    createFruit();
                case 2 ->
                    viewOrder();
                case 3 ->
                    shopping();
                case 4 -> {
                    System.out.println("Thank you for using FRUIT SHOP SYSTEM!");
                    return;
                }
            }
        }
    }

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
            if (fruitDAO.insertFruit(newFruit)) {
                System.out.println("Fruit created successfully.");
            } else {
                System.err.println("Failed to save fruit to database.");
            }

            if (!Validation.checkInputYN("Do you want to continue (Y/N)? ")) {
                return;
            }
        }
    }

    private void viewOrder() {
        try ( Connection con = DBConnect.getConnection()) {
            if (con == null) {
                return;
            }

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

            if (!Validation.checkInputYN("Do you want to check out ? (Y/N)")) {
                continue; // Tiếp tục mua sắm
            }

            processTransaction(currentOrderList);
            return;
        }
    }

    private void processTransaction(ArrayList<Order> currentOrderList) {
        Connection con = null;
        try {
            con = DBConnect.getConnection();
            if (con == null) {
                return;
            }

            con.setAutoCommit(false);

            displayListOrder(currentOrderList);
            System.out.print("Input your name: ");
            String name = Validation.checkInputString();

            int orderId = orderDAO.createCustomerOrder(con, name);

            for (Order item : currentOrderList) {
                orderDAO.addOrderDetail(con, orderId, item);

                fruitDAO.updateStock(con, item.getFruitId(), -item.getQuantity());
            }

            con.commit();
            System.out.println("Order added successfully for customer: " + name);

        } catch (SQLException e) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex) {
                System.err.println("Rollback failed: " + ex.getMessage());
            }
            System.err.println("Transaction failed. Changes reverted. Error: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
            }
        }
    }

    private void displayListFruit(List<Fruit> lf) {
        int countItem = 1;
        System.out.println("--------- List of Fruit ----------");
        System.out.printf("%-10s%-20s%-15s%-15s\n", "Item", "Fruit Name", "Origin", "Price");
        for (Fruit fruit : lf) {
            if (fruit.getQuantity() > 0) {
                System.out.printf("%-10d%-20s%-15s%-15.0f$\n", countItem++,
                        fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());
            }
        }
    }

    private void displayListOrder(ArrayList<Order> lo) {
        double total = 0;
        System.out.println("Product | Quantity | Price | Amount");
        for (Order order : lo) {
            double amount = order.getPrice() * order.getQuantity();
            System.out.printf("%s | %d | %.0f$ | %.0f$\n", order.getFruitName(),
                    order.getQuantity(), order.getPrice(), amount);
            total += amount;
        }
        System.out.println("Total: " + total + "$");
    }

    private void updateOrder(ArrayList<Order> lo, String id, int quantity) {
        for (Order order : lo) {
            if (order.getFruitId().equalsIgnoreCase(id)) {
                order.setQuantity(order.getQuantity() + quantity);
                return;
            }
        }
    }

}
