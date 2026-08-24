package com.ideao.dev.javadatabase.coffee;

public class Coffee {
   private String name;
   private long supId;
   private double price;
   private int sales;
   private int total;

    public Coffee() {}

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

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getSales() {
        return sales;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "(" + name + ", " + supId + ", " + price + ", " + sales + ", " + total + ")";
    }
}