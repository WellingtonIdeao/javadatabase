package com.ideao.dev.javadatabase.model.dto;

public class CoffeeDTO {
    private String name;
    private long supId;
    private double price;
    private int sales;
    private int total;

    public CoffeeDTO(String name, long supId, double price, int sales, int total) {
        this.name = name;
        this.supId = supId;
        this.price = price;
        this.sales = sales;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public long getSupId() {
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

    @Override
    public String toString() {
        return "Coffee{" +
                "name='" + name + '\'' +
                ", supId=" + supId +
                ", price=" + price +
                ", sales=" + sales +
                ", total=" + total +
                '}';
    }
}
