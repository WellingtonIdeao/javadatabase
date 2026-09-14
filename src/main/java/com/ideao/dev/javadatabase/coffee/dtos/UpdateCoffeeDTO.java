package com.ideao.dev.javadatabase.coffee.dtos;

import java.math.BigDecimal;

public class UpdateCoffeeDTO {
    private Long id;
    private String name;
    private Long supplierId;
    private BigDecimal price;
    private int sales;
    private int total;

    public UpdateCoffeeDTO(Long id, String name, Long supplierId, BigDecimal price, int sales, int total) {
        this.id = id;
        this.name = name;
        this.supplierId = supplierId;
        this.price = price;
        this.sales = sales;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
