package com.ideao.dev.javadatabase.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
        }
    }

    public void populateTable() throws SQLException {
        try (Statement stmt = connection.createStatement()) {
           stmt.executeUpdate("INSERT INTO suppliers " +
                   "VALUES(49, 'Superior Coffee', '1 Party Place', 'Mendocino', 'CA', '95460')");
            stmt.executeUpdate("INSERT INTO suppliers " +
                    "VALUES(101, 'Acne, Inc.', '99 Market Street', 'GroundVille', 'CA', '95199')");
            stmt.executeUpdate("INSERT INTO suppliers " +
                    "VALUES(150, 'The High Ground', '100 Coffee Lane', 'Meadows', 'CA', '93966')");
        }
    }

    public void viewTable() throws SQLException {
        String query = "SELECT name, street, city, state, zip FROM suppliers";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
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
