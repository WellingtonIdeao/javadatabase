package com.ideao.dev.javadatabase.coffee;

import com.ideao.dev.javadatabase.supplier.Supplier;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.math.BigDecimal;

@Entity
@SQLDelete(sql = "UPDATE coffee SET is_active = false WHERE id = ?")
@Where(clause = "is_active = true")
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", foreignKey = @ForeignKey(name = "fk_coffee_supplier"))
    private Supplier supplier;

    private BigDecimal price;
    private int sales;
    private int total;

    @Column(name = "is_active")
    private Boolean isActive = true;

    public Coffee() {}

    public Coffee(Long id, String name, BigDecimal price, int sales, int total) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sales = sales;
        this.total = total;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSupplier(Supplier supplier) {
        addSupplier(supplier);
        supplier.addCoffee(this);
    }

    public void addSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "(" + name + ", " + supplier + ", " + price + ", " + sales + ", " + total + ")";
    }
}