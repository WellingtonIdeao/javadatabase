package com.ideao.dev.javadatabase.model.entity;

public class Coffee {
   private String name;
   private long supId;
   private double price;
   private int sales;
   private int total;

    public Coffee(String name, long supId, double price, int sales, int total) {
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
}