package com.ideao.dev.javadatabase.supplier.dtos;

import com.ideao.dev.javadatabase.supplier.Uf;

public class SupplierDTO {
    private Long id;
    private String name;
    private String street;
    private String city;
    private Uf state;
    private String zip;

    public SupplierDTO(Long id, String name, String street, String city, Uf state, String zip) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Long getId() {
        return id;
    }

    public String getStreet() {
       return street;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Uf getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}