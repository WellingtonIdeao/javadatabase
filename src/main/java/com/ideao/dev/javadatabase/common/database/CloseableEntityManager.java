package com.ideao.dev.javadatabase.common.database;

import jakarta.persistence.EntityManager;

public class CloseableEntityManager implements AutoCloseable {
    private final EntityManager em;

    public CloseableEntityManager() {
        this.em = JPASingleton.getInstance().getEntityManager();
    }

    public EntityManager get() {
        return em;
    }

    @Override
    public void close() throws Exception {
        JPASingleton.getInstance().closeEntityManager();
    }
}