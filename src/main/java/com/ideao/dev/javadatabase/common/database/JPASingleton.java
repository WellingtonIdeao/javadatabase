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
    private final ThreadLocal<EntityManager> threadLocalEm = new ThreadLocal<>();
    private HikariDataSource sharedDataSource;

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
        EntityManager em = threadLocalEm.get();
        if( em == null || !em.isOpen()) {
            em = emf.createEntityManager();
            threadLocalEm.set(em);
        }
        return em;
    }

    private final void init() {
        try {
            HikariConfig config = new HikariConfig("/hikari.properties");
            sharedDataSource = new HikariDataSource(config);

            Flyway flyway = Flyway.configure().dataSource(sharedDataSource).locations("classpath:db/migration").load();
            flyway.migrate();

            Map<String, Object> propsJpa = new HashMap<>();
            propsJpa.put("jakarta.persistence.nonJtaDataSource", sharedDataSource);

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

        if (sharedDataSource != null && !sharedDataSource.isClosed()) {
            System.out.println("[JPA] Fechando Pool de Conexões HikariCP...");
            sharedDataSource.close();
        }
        System.out.println("[JPA] Recursos liberados com sucesso.");
    }

    public ThreadLocal<EntityManager> getThreadLocalEm() {
        return threadLocalEm;
    }

    public void closeEntityManager() {
        EntityManager em = threadLocalEm.get();
        if (em != null && em.isOpen()) {
            em.close();
        }
        threadLocalEm.remove();
    }
}