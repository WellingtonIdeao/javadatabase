package com.ideao.dev.javadatabase.model.service;

import com.ideao.dev.javadatabase.model.dao.CoffeeDao;
import com.ideao.dev.javadatabase.model.dao.DAOFactory;
import com.ideao.dev.javadatabase.model.entity.Coffee;

import java.util.List;

public class CoffeeService {
    private final CoffeeDao coffeeDao;

    public CoffeeService() {
        this.coffeeDao = DAOFactory.createCoffeeDAO();
    }

    public List<Coffee> viewList() {
        return coffeeDao.viewList();
    }
}
