package com.ideao.dev.javadatabase.coffee;

import com.ideao.dev.javadatabase.coffee.dtos.AddCoffeeDTO;
import com.ideao.dev.javadatabase.coffee.dtos.CoffeeDTO;
import com.ideao.dev.javadatabase.coffee.dtos.UpdateCoffeeDTO;

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
        if( coffeeDTO.getSupId() == 0) {
            System.out.println("Coffee is invalid.");
        } else {
            coffeeService.add(coffeeDTO);
        }
    }

    public void update(UpdateCoffeeDTO coffeeDTO) {
        if (coffeeDTO.getName() == null || coffeeDTO.getName().isEmpty()) {
            System.out.println("Coffee is invalid.");
        } else {
            coffeeService.update(coffeeDTO);
        }
    }

    public void delete(String id) {
        coffeeService.delete(id);
    }
}