package com.ideao.dev.javadatabase.util;

import java.sql.*;

public class CoffeeTable {
    private final Connection connection;

    public CoffeeTable(Connection connection) {
        this.connection = connection;
    }

    public void createTable() throws SQLException {
        String sql =
                "CREATE TABLE IF NOT EXISTS coffees (" +
                "name VARCHAR(32) NOT NULL, " +
                "sup_id INT NOT NULL, " +
                "price NUMERIC(10,2) NOT NULL, " +
                "sales INTEGER NOT NULL, " +
                "total INTEGER NOT NULL, " +
                "PRIMARY KEY (name), " +
                "FOREIGN KEY (sup_id) REFERENCES supplier (id))";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.executeUpdate();
        }
    }

    public void populateTable() throws SQLException {
        String sql = "INSERT INTO coffees VALUES(?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
           pstmt.setString(1, "Colombian");
           pstmt.setInt(2, 101);
           pstmt.setDouble(3, 7.99);
           pstmt.setInt(4, 0);
           pstmt.setInt(5, 0);
           pstmt.executeUpdate();

           pstmt.setString(1, "French_Roast");
           pstmt.setInt(2, 49);
           pstmt.setDouble(3, 8.99);
           pstmt.setInt(4, 0);
           pstmt.setInt(5, 0);
           pstmt.executeUpdate();

           pstmt.setString(1, "Espresso");
           pstmt.setInt(2, 150);
           pstmt.setDouble(3, 9.99);
           pstmt.setInt(4, 0);
           pstmt.setInt(5, 0);
           pstmt.executeUpdate();

           pstmt.setString(1, "Colombian_Decaf");
           pstmt.setInt(2, 101);
           pstmt.setDouble(3, 8.99);
           pstmt.setInt(4, 0);
           pstmt.setInt(5, 0);
           pstmt.executeUpdate();

           pstmt.setString(1, "French_Roast_Decaf");
           pstmt.setInt(2, 49);
           pstmt.setDouble(3, 9.99);
           pstmt.setInt(4, 0);
           pstmt.setInt(5, 0);
           pstmt.executeUpdate();
        }
    }

    public void viewTable() throws SQLException {
        String sql = "SELECT name, price, sales, total FROM coffees";

        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int sales = rs.getInt("sales");
                int total =  rs.getInt("total");

                System.out.println(name + ", " + price + ", " + sales + ", " + total);
            }
        }
    }

    public void batchUpdate() throws SQLException {
        String sql = "INSERT INTO coffees VALUES(?, ?, ?, ?, ?)";
        connection.setAutoCommit(false);

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, "Amaretto");
            pstmt.setInt(2, 49);
            pstmt.setDouble(3, 9.99);
            pstmt.setInt(4, 0);
            pstmt.setInt(5, 0);
            pstmt.addBatch();

            pstmt.setString(1, "Hazelnut");
            pstmt.setInt(2, 49);
            pstmt.setDouble(3, 9.99);
            pstmt.setInt(4, 0);
            pstmt.setInt(5, 0);
            pstmt.addBatch();

            pstmt.setString(1, "Amaretto_decaf");
            pstmt.setInt(2, 49);
            pstmt.setDouble(3, 10.99);
            pstmt.setInt(4, 0);
            pstmt.setInt(5, 0);
            pstmt.addBatch();

            pstmt.setString(1, "Hazelnut_decaf");
            pstmt.setInt(2, 49);
            pstmt.setDouble(3, 10.99);
            pstmt.setInt(4, 0);
            pstmt.setInt(5, 0);
            pstmt.addBatch();

            int[] updateCounts = pstmt.executeBatch();
            connection.commit();
        } finally {
            connection.setAutoCommit(true);
        }
    }
}
