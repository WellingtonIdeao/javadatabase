package com.ideao.dev.javadatabase.coffee;

import com.ideao.dev.javadatabase.coffee.dtos.CreateCoffeeDTO;
import com.ideao.dev.javadatabase.coffee.dtos.UpdateCoffeeDTO;
import com.ideao.dev.javadatabase.coffee.dtos.CoffeeDTO;
import com.ideao.dev.javadatabase.coffee.exceptions.CoffeeNotFoundException;
import com.ideao.dev.javadatabase.common.exceptions.BusinessException;

import java.util.List;

public class CoffeeController {
    private final CoffeeServiceJPA coffeeService;
    private final CoffeeView coffeeView;

    public CoffeeController() {
        this.coffeeService = new CoffeeServiceJPA();
        this.coffeeView = new CoffeeView();
    }
    public void list() {
        List<CoffeeDTO> coffeesDTOs = coffeeService.list();
        coffeeView.viewJson(coffeesDTOs);
    }

    public void view(Long id) {
        try {
            CoffeeDTO coffee = coffeeService.findById(id);
            coffeeView.viewDetails(coffee);
        } catch (CoffeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void create(CreateCoffeeDTO coffeeDTO) {
        if( coffeeDTO.getSupplierId() == null || coffeeDTO.getSupplierId() == 0L) {
            System.out.println("Coffee is invalid.");
        } else {
            try {
                coffeeService.create(coffeeDTO);
            } catch (BusinessException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void update(UpdateCoffeeDTO coffeeDTO) {
        if (coffeeDTO.getName() == null || coffeeDTO.getName().isEmpty()) {
            System.out.println("Coffee is invalid.");
        } else {
            try {
                coffeeService.update(coffeeDTO);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void delete(Long id) {
        try {
            coffeeService.delete(id);
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
        }
    }
}
