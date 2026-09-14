package com.ideao.dev.javadatabase.supplier.dtos;

import com.ideao.dev.javadatabase.supplier.Uf;

public class CreateSupplierDTO {
    private String name;
    private String street;
    private String city;
    private Uf state;
    private String zip;

    public CreateSupplierDTO(String name, String street, String city, Uf state, String zip) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
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
}