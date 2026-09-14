package com.ideao.dev.javadatabase.coffee.dtos;

import com.ideao.dev.javadatabase.supplier.dtos.SupplierDTO;

import java.math.BigDecimal;

public class CoffeeDTO {
    private Long id;
    private String name;
    private SupplierDTO supplierDTO;
    private BigDecimal price;
    private int sales;
    private int total;

    public CoffeeDTO(Long id, String name, BigDecimal price, int sales, int total) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sales = sales;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public SupplierDTO getSupplier() {
        return supplierDTO;
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

    public SupplierDTO getSupplierDTO() {
        return supplierDTO;
    }

    public void setSupplierDTO(SupplierDTO supplierDTO) {
        this.supplierDTO = supplierDTO;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "name='" + name + '\'' +
                ", supId=" + supplierDTO.getId() +
                ", price=" + price +
                ", sales=" + sales +
                ", total=" + total +
                '}';
    }
}
