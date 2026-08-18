package com.ideao.dev.javadatabase.model.dao;

import com.ideao.dev.javadatabase.model.entity.Coffee;
import com.ideao.dev.javadatabase.model.entity.Supplier;

public class DAOFactory {

    public static GenericRepository<Supplier, Long> createSupplierDAO() {
        return new SupplierDaoJdbc();
    }

    public static GenericRepository<Coffee, String> createCoffeeDAO() {
        return new CoffeeDaoJdbc();
    }
}
