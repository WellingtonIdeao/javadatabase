package com.ideao.dev.javadatabase.model.service;

import com.ideao.dev.javadatabase.model.dao.DAOFactory;
import com.ideao.dev.javadatabase.model.dao.GenericRepository;
import com.ideao.dev.javadatabase.model.entity.Coffee;

import java.util.List;

public class CoffeeService {
    private final GenericRepository<Coffee, String> repository;

    public CoffeeService() {
        this.repository = DAOFactory.createCoffeeDAO();
    }

    public List<Coffee> viewList() {
        return repository.viewList();
    }
}
