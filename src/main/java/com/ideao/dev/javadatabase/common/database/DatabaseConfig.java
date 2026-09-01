package com.ideao.dev.javadatabase.common.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConfig {
    private static final DatabaseConfig INSTANCE = new DatabaseConfig();
    private HikariDataSource dataSource;

    private DatabaseConfig() {
       init();
    }

    public static DatabaseConfig getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() throws SQLException {
        if (dataSource == null || dataSource.isClosed()) {
           throw new IllegalStateException("O pool de conexões (HikariCP) está fechado ou não foi inicializado.");
        }
        return dataSource.getConnection();

    }

    private final void init() {
        try {
            HikariConfig config = new HikariConfig("/hikari.properties");
            dataSource = new HikariDataSource(config);

            Flyway flyway = Flyway.configure().dataSource(dataSource).locations("classpath:db/migration").load();
            flyway.migrate();

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                if (dataSource != null && !dataSource.isClosed()) {
                    dataSource.close();
                    System.out.println("HikariCP: Pool de conexões encerrado com sucesso.");
                }
            }));
        } catch (Exception e) {
            throw new RuntimeException("Falha crítica ao iniciar o pool HikariCP", e);
        }
    }
}
