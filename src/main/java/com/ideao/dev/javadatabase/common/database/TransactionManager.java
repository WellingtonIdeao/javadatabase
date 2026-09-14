package com.ideao.dev.javadatabase.common.database;

import com.ideao.dev.javadatabase.common.exceptions.BusinessException;
import com.ideao.dev.javadatabase.common.exceptions.InfraException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.function.Consumer;
import java.util.function.Function;

public class TransactionManager {

    public static void execute(Consumer<EntityManager> action) {
        EntityManager em = null;
        EntityTransaction tx = null;
        Throwable mainError = null;
        try {
            try {
                em = JPASingleton.getInstance().getEntityManager();
                tx = em.getTransaction();
                tx.begin();
                action.accept(em);
                tx.commit();
            } catch (Throwable t) {
                if (tx != null && tx.isActive()) {
                    tx.rollback();
                }
                mainError = t;
                throw t;
            } finally {
                    if (mainError != null) {
                        try {
                           JPASingleton.getInstance().closeEntityManager();
                        } catch (Throwable t) {
                            mainError.addSuppressed(t);
                        }
                    } else {
                        JPASingleton.getInstance().closeEntityManager();
                    }
            }
        }catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            throw new InfraException("Falha crítica durante a execução da transação.", e);
        }
    }

    public static <T> T execute(Function<EntityManager, T> action) {
        EntityManager em = null;
        EntityTransaction tx = null;
        Throwable mainError = null;
        try {
            try {
                em = JPASingleton.getInstance().getEntityManager();
                tx = em.getTransaction();
                tx.begin();
                T result = action.apply(em);
                tx.commit();
                return result;
            } catch (Throwable t) {
                if (tx != null && tx.isActive()) {
                    tx.rollback();
                }
                mainError = t;
                throw t;
            } finally {
                if (mainError != null) {
                    try {
                        JPASingleton.getInstance().closeEntityManager();
                    } catch (Throwable t) {
                        mainError.addSuppressed(t);
                    }
                } else {
                    JPASingleton.getInstance().closeEntityManager();
                }
            }
        }catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            throw new InfraException("Falha crítica durante a execução da transação.", e);
        }
    }
}