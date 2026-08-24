package com.ideao.dev.javadatabase.model.dto;

public class AddCoffeeDTO {
    private String name;
    private Long supId;
    private double price;
    private int sales;
    private int total;

    public AddCoffeeDTO(String name, Long supId, double price, int sales, int total) {
        this.name = name;
        this.supId = supId;
        this.price = price;
        this.sales = sales;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public Long getSupId() {
        return supId;
    }

    public double getPrice() {
        return price;
    }

    public int getSales() {
        return sales;
    }

    public int getTotal() {
        return total;
    }
}
