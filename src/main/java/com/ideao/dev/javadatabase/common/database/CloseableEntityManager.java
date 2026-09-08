package com.ideao.dev.javadatabase.common.database;

import jakarta.persistence.EntityManager;

public class CloseableEntityManager implements AutoCloseable {
    private final EntityManager em;

    public CloseableEntityManager(EntityManager em) {
        this.em = em;
    }

    public EntityManager getEntityManager() {
        return em;
    }


    @Override
    public void close() throws Exception {
       if (em != null && em.isOpen()) {
           em.close();
       }
    }
}