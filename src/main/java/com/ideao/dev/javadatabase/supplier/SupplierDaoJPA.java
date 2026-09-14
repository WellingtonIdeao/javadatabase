package com.ideao.dev.javadatabase.supplier;

import com.ideao.dev.javadatabase.common.database.JPASingleton;
import com.ideao.dev.javadatabase.common.exceptions.InfraException;
import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;

public class SupplierDaoJPA {

    public List<Supplier> list() {
        try {
            EntityManager em = JPASingleton.getInstance().getEntityManager();
            TypedQuery<Supplier> query =
                    em.createQuery(
                            "SELECT s FROM Supplier s",
                            Supplier.class
                    );
            return query.getResultList();
        } catch (Exception e) {
            throw new InfraException("Falha crítica ao buscar todas as entidades no banco de dados", e);
        }
    }

    public void create(Supplier supplier) {
        try {
            EntityManager em = JPASingleton.getInstance().getEntityManager();
            em.persist(supplier);
        } catch (Exception e) {
            throw new InfraException("Erro técnico ao persistir a entidade no banco de dados", e);
        }
    }

    public Optional<Supplier> findById(Long id) {
        try {
            EntityManager em = JPASingleton.getInstance().getEntityManager();
            Supplier supplier = em.find(Supplier.class, id);
            if (supplier == null) {
                return Optional.empty();
            }
            return  Optional.of(supplier);
        } catch (Exception e) {
            throw new InfraException("Falha crítica ao buscar a entidade no banco de dados", e);
        }
    }

    public Optional<Supplier> getReference(Long id) {
        try {
            EntityManager em = JPASingleton.getInstance().getEntityManager();
            Supplier supplier = em.getReference(Supplier.class, id);
            return Optional.of(supplier);
        } catch (EntityNotFoundException e1) {
            return Optional.empty();
        } catch (Exception e) {
            throw new RuntimeException("Falha crítica ao acessar o banco de dados", e);
        }
    }
}