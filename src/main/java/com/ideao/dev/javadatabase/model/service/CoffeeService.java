package com.ideao.dev.javadatabase.model.service;

import com.ideao.dev.javadatabase.model.dao.DAOFactory;
import com.ideao.dev.javadatabase.model.dao.GenericRepository;
import com.ideao.dev.javadatabase.model.entity.Coffee;
import com.ideao.dev.javadatabase.model.entity.Supplier;

import java.util.List;

public class CoffeeService {
    private final GenericRepository<Coffee, String> coffeeRepository;
    private final GenericRepository<Supplier, Long> supplierRepository;

    public CoffeeService() {
        this.coffeeRepository = DAOFactory.createCoffeeDAO();
        this.supplierRepository = DAOFactory.createSupplierDAO();

    }

    public List<Coffee> viewList() {
        return coffeeRepository.viewList();
    }

    public void add(Coffee coffee) {
        Boolean existsSupplier = supplierRepository.existsById(coffee.getSupId());

        if (existsSupplier) {
           coffeeRepository.create(coffee);
        } else {
            System.out.println("Coffee with invalid Supplier.");
        }
    }

    public  Coffee read(String id) {
        return coffeeRepository.read(id);
    }

    public void delete(String id) {
        coffeeRepository.delete(id);
    }

    public void update(Coffee coffee) {
       boolean existsCoffee =  coffeeRepository.existsById(coffee.getName());
       boolean existsSupplier = supplierRepository.existsById(coffee.getSupId());

       if (existsCoffee && existsSupplier) {
           coffeeRepository.update(coffee);
       } else {
           System.out.println("Coffee invalid.");
       }
    }
}
