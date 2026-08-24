package com.ideao.dev.javadatabase.coffee;

import com.ideao.dev.javadatabase.coffee.dto.CoffeeDTO;

import java.util.List;

public class CoffeeView {

    public void viewJson(List<CoffeeDTO> coffeeDTOs) {
        for (CoffeeDTO coffee: coffeeDTOs) {
            System.out.println("{");
            System.out.println("\t\"name\": " + coffee.getName());
            System.out.println("\t\"sup id\": " + coffee.getSupId());
            System.out.println("\t\"price\": " + coffee.getPrice());
            System.out.println("\t\"sales\": " + coffee.getSales());
            System.out.println("\t\"total\": " + coffee.getTotal());
            System.out.println("}");
        }
    }

    public void viewDetails(CoffeeDTO coffeeDTO) {
        if (coffeeDTO != null) {
            System.out.println(coffeeDTO);
        } else {
            System.out.println("Coffee not found");
        }
    }
}