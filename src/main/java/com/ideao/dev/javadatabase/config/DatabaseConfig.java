package com.ideao.dev.javadatabase.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConfig {
    private static final HikariDataSource DATASOURCE;

    static {
        try {
            HikariConfig config = new HikariConfig("/hikari.properties");
            DATASOURCE = new HikariDataSource(config);

            Flyway flyway = Flyway.configure().dataSource(DATASOURCE).locations("classpath:db/migration").load();
            flyway.migrate();

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                if (!DATASOURCE.isClosed()) {
                    DATASOURCE.close();
                    System.out.println("HikariCP: Pool de conexões encerrado com sucesso.");
                }
            }));
        } catch (Exception e) {
            throw new RuntimeException("Falha crítica ao inicializar o banco de dados", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DATASOURCE.getConnection();
    }
}
