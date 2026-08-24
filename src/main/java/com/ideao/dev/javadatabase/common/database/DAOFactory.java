package com.ideao.dev.javadatabase.common.database;

import com.ideao.dev.javadatabase.coffee.Coffee;
import com.ideao.dev.javadatabase.coffee.CoffeeDaoJdbc;
import com.ideao.dev.javadatabase.common.repository.GenericRepository;
import com.ideao.dev.javadatabase.supplier.SupplierDaoJdbc;
import com.ideao.dev.javadatabase.supplier.Supplier;

public class DAOFactory {

    public static GenericRepository<Supplier, Long> createSupplierDAO() {
        return new SupplierDaoJdbc();
    }

    public static GenericRepository<Coffee, String> createCoffeeDAO() {
        return new CoffeeDaoJdbc();
    }
}
