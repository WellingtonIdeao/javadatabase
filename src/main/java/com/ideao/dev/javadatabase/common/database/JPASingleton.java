package com.ideao.dev.javadatabase.common.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.flywaydb.core.Flyway;

import java.util.HashMap;
import java.util.Map;

public class JPASingleton {
    private static final JPASingleton INSTANCE = new JPASingleton();
    private EntityManagerFactory emf;
    private HikariDataSource dataSource;

    private JPASingleton() {
        init();
    }

    public static JPASingleton getInstance() {
        return INSTANCE;
    }

    public EntityManager getEntityManager() {
        if (emf == null || !emf.isOpen()) {
            throw  new IllegalStateException("A EntityManagerFactory está fechada ou não foi inicializada.");
        }
        return emf.createEntityManager();
    }

    private final void init() {
        try {
            HikariConfig config = new HikariConfig("/hikari.properties");
            dataSource = new HikariDataSource(config);

            Flyway flyway = Flyway.configure().dataSource(dataSource).locations("classpath:db/migration").load();
            flyway.migrate();

            Map<String, Object> propsJpa = new HashMap<>();
            propsJpa.put("jakarta.persistence.dataSource", dataSource);
            propsJpa.put("hibernate.connection.datasource", dataSource);
            propsJpa.put("hibernate.hbm2ddl.auto", "validate");
            propsJpa.put("hibernate.connection.provider_class",
                    "org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl");

            propsJpa.put("jakarta.persistence.jdbc.url", dataSource.getJdbcUrl());


            emf = Persistence.createEntityManagerFactory("com.ideao.dev.javadatabase.jpa", propsJpa);
            Runtime.getRuntime().addShutdownHook(new Thread(this::closeResources));

        } catch (Exception e) {
            throw new RuntimeException("Falha crítica ao iniciar o pool HikariCP", e);
        }
    }

    private synchronized void closeResources() {
        System.out.println("[JPA] Executando rotina de fechamento de recursos...");

        if (emf != null && emf.isOpen()) {
            System.out.println("[JPA] Fechando EntityManagerFactory...");
            emf.close();
        }

        if (dataSource != null && !dataSource.isClosed()) {
            System.out.println("[JPA] Fechando Pool de Conexões HikariCP...");
            dataSource.close();
        }
        System.out.println("[JPA] Recursos liberados com sucesso.");
    }
}