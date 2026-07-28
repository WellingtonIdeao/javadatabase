package com.ideao.dev.javadatabase.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcConnection {
    private static final HikariDataSource DATASOURCE;

    static {
        HikariConfig config = new HikariConfig("/hikari.properties");
        DATASOURCE = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return DATASOURCE.getConnection();
    }

    public static void closePool() {
       if (DATASOURCE != null && !DATASOURCE.isClosed()) {
          DATASOURCE.close();
       }
    }
}
