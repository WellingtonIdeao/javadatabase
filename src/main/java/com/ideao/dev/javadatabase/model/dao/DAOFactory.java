package com.ideao.dev.javadatabase.model.dao;

public class DAOFactory {

    public static SupplierDAO createSupplierDAO() {
        return new SupplierDaoJdbc();
    }

    public static CoffeeDao createCoffeeDAO() {
        return new CoffeeDaoJdbc();
    }
}
