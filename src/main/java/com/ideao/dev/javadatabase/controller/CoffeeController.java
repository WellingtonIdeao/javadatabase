package com.ideao.dev.javadatabase.controller;

import com.ideao.dev.javadatabase.model.entity.Coffee;
import com.ideao.dev.javadatabase.model.service.CoffeeService;
import com.ideao.dev.javadatabase.view.CoffeeView;

import java.util.List;

public class CoffeeController {
    private final CoffeeService coffeeService;
    private final CoffeeView coffeeView;

    public CoffeeController() {
        this.coffeeService = new CoffeeService();
        this.coffeeView = new CoffeeView();
    }
    public void viewList() {
        List<Coffee> coffees = coffeeService.viewList();

        coffeeView.viewJson(coffees);
    }

    public void add() {
       Coffee coffee = new Coffee("Novo café", 5, 14.99, 0, 0);
       coffeeService.add(coffee);
    }

    public void view() {
        String id = "Novo café";
        Coffee coffee = coffeeService.read(id);
        coffeeView.viewDetails(coffee);
    }

    public void delete() {
        String id = "Novo café";
        coffeeService.delete(id);
    }

    public void update() {
       Coffee coffee = new Coffee("Novo café", 5, 15.99, 1, 0) ;
       coffeeService.update(coffee);
    }


}