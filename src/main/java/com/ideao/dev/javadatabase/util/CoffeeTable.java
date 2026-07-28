package com.ideao.dev.javadatabase.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
        }
    }
}
