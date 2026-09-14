package com.ideao.dev.javadatabase.coffee;

import com.ideao.dev.javadatabase.common.database.JPASingleton;
import com.ideao.dev.javadatabase.common.exceptions.InfraException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class CoffeeDaoJPA {

    public List<Coffee> list() {
        try {
            EntityManager em = JPASingleton.getInstance().getEntityManager();
            TypedQuery<Coffee> query =
                    em.createQuery(
                            "SELECT c FROM Coffee c",
                            Coffee.class
                    );
            return query.getResultList();
        } catch (Exception e) {
            throw new InfraException("Falha crítica ao buscar todas as entidades no banco de dados", e);
        }
    }

    public void create(Coffee coffee) {
        try {
            EntityManager em = JPASingleton.getInstance().getEntityManager();
            em.persist(coffee);
        } catch (Exception e) {
            throw new InfraException("Falha crítica ao persistir a entidade no banco de dados", e);
        }
    }

    public Optional<Coffee> findById(Long id) {
        try {
            EntityManager em = JPASingleton.getInstance().getEntityManager();
            Coffee coffee = em.find(Coffee.class, id);
            if (coffee == null) {
                return Optional.empty();
            }
            return Optional.of(coffee);
        } catch (Exception e) {
            throw new InfraException("Falha crítica ao buscar a entidade no banco de dados", e);
        }
    }
}