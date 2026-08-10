package com.ideao.dev.javadatabase.controller;

import com.ideao.dev.javadatabase.model.entity.Coffee;
import com.ideao.dev.javadatabase.model.service.CoffeeService;
import com.ideao.dev.javadatabase.view.CoffeeView;

import java.util.List;

public class CoffeeController {
    private CoffeeService coffeeService;

    public CoffeeController() {
        coffeeService = new CoffeeService();
    }
    public void viewList() {
        List<Coffee> coffees = coffeeService.viewList();
        CoffeeView view = new CoffeeView();

        view.viewJson(coffees);
    }
}