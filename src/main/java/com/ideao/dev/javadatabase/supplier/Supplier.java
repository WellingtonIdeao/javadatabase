package com.ideao.dev.javadatabase.supplier;

import com.ideao.dev.javadatabase.coffee.Coffee;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.ArrayList;
import java.util.List;

@Entity
@SQLDelete(sql = "UPDATE supplier SET is_active = false WHERE id = ?")
@Where(clause = "is_active = true")
public class Supplier {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(length = 40)
    private String name;

    @Column(length = 40)
    private String street;

    @Column(length = 20)
    private String city;

    @Enumerated(EnumType.STRING)
    @Column(length = 2)
    private Uf state;

    @Column(length = 5)
    private String zip;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Coffee> coffees = new ArrayList<>();

    public Supplier() {}

    public Supplier(Long id, String name, String street, String city, Uf state, String zip) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    public String getStreet() {
        return street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setState(Uf state) {
        this.state = state;
    }

    public Uf getState() {
        return state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getZip() {
        return zip;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<Coffee> getCoffees() {
        return coffees;
    }

    public void setCoffees(List<Coffee> coffees) {
        this.coffees = coffees;
    }

    public void addCoffee(Coffee coffee) {
        coffees.add(coffee);
    }

    public void removerCoffee(Coffee coffee) {
        coffees.remove(coffee);
        coffee.setSupplier(null);
    }
    @Override
    public String toString() {
        return "(" + id + ", " + name + ", " + street + ", " + city + ", " + state + ", " + zip + ")" ;
    }
}