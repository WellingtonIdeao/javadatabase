package com.ideao.dev.javadatabase.util;

import java.sql.*;

public class SupplierTable {
    private final Connection connection;

    public SupplierTable(Connection connection) {
       this.connection = connection;
    }

    public  void createTable() throws SQLException {
        String sql =
                "CREATE TABLE IF NOT EXISTS suppliers (" +
                "id INTEGER NOT NULL, " +
                "name VARCHAR(40) NOT NULL, " +
                "street VARCHAR(40) NOT NULL, " +
                "city VARCHAR(20) NOT NULL, " +
                "state CHAR(2) NOT NULL, " +
                "zip CHAR(5), " +
                "PRIMARY KEY (id))";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.executeUpdate();
        }
    }

    public void populateTable() throws SQLException {
        String sql = "INSERT INTO suppliers VALUES(?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, 49);
            pstmt.setString(2, "Superior Coffee");
            pstmt.setString(3, "1 Party Place");
            pstmt.setString(4, "Mendocino");
            pstmt.setString(5, "CA");
            pstmt.setString(6, "95460");
            pstmt.executeUpdate();

            pstmt.setInt(1, 101);
            pstmt.setString(2, "Acne, Inc.");
            pstmt.setString(3, "99 Market Street");
            pstmt.setString(4, "GroundVille");
            pstmt.setString(5, "CA");
            pstmt.setString(6, "95199");
            pstmt.executeUpdate();

            pstmt.setInt(1, 150);
            pstmt.setString(2, "The High Ground");
            pstmt.setString(3, "100 Coffee Lane");
            pstmt.setString(4, "Meadows");
            pstmt.setString(5, "CA");
            pstmt.setString(6, "93966");
            pstmt.executeUpdate();
        }
    }

    public void viewTable() throws SQLException {
        String sql = "SELECT name, street, city, state, zip FROM suppliers";

        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String name = rs.getString("name");
                String street = rs.getString("street");
                String city = rs.getString("city");
                String state = rs.getString("state");
                String zip = rs.getString("zip");

                System.out.println(name + ", " + street + ", " + city + ", " + state + ", " + zip);
            }
        }
    }
}
