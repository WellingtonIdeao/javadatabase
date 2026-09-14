package com.ideao.dev.javadatabase.coffee.dtos;

import java.math.BigDecimal;

public class CreateCoffeeDTO {
    private String name;
    private Long supplierId;
    private BigDecimal price;
    private int sales;
    private int total;

    public CreateCoffeeDTO(String name, Long supplierId, BigDecimal price, int sales, int total) {
        this.name = name;
        this.supplierId = supplierId;
        this.price = price;
        this.sales = sales;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getSales() {
        return sales;
    }

    public int getTotal() {
        return total;
    }
}
