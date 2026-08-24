package com.ideao.dev.javadatabase.controller;

import com.ideao.dev.javadatabase.model.dto.*;
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
        List<CoffeeDTO> coffeesDTOs = coffeeService.viewList();

        coffeeView.viewJson(coffeesDTOs);
    }

    public void view(String id) {
        CoffeeDTO coffee = coffeeService.read(id);
        coffeeView.viewDetails(coffee);
    }

    public void add(AddCoffeeDTO coffeeDTO) {
       coffeeService.add(coffeeDTO);
    }

    public void update(UpdateCoffeeDTO coffeeDTO) {
        coffeeService.update(coffeeDTO);
    }

    public void delete(String id) {
        coffeeService.delete(id);
    }
}