package com.ideao.dev.javadatabase.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:sqlite:sample.db");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
