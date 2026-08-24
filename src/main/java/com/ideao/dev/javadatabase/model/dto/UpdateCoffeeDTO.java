package com.ideao.dev.javadatabase.model.dto;

public class UpdateCoffeeDTO {
    private String name;
    private long supId;
    private double price;
    private int sales;
    private int total;

    public UpdateCoffeeDTO(String name, long supId, double price, int sales, int total) {
        this.name = name;
        this.supId = supId;
        this.price = price;
        this.sales = sales;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSupId() {
        return supId;
    }

    public void setSupId(long supId) {
        this.supId = supId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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
