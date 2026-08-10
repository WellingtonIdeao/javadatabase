package com.ideao.dev.javadatabase.view;

import com.ideao.dev.javadatabase.model.entity.Coffee;

import java.util.List;

public class CoffeeView {

    public void viewJson(List<Coffee> coffees) {
        for (Coffee coffee: coffees) {
            System.out.println("{");
            System.out.println("\t\"name\": " + coffee.getName());
            System.out.println("\t\"sup id\": " + coffee.getSupId());
            System.out.println("\t\"price\": " + coffee.getPrice());
            System.out.println("\t\"sales\": " + coffee.getSales());
            System.out.println("\t\"total\": " + coffee.getTotal());
            System.out.println("}");
        }
    }
}