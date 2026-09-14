package com.ideao.dev.javadatabase.supplier.dtos;

import com.ideao.dev.javadatabase.supplier.Uf;

public class UpdateSupplierDTO {
    private Long id;
    private String name;
    private String street;
    private String city;
    private Uf state;
    private String zip;

    public UpdateSupplierDTO(Long id, String name, String street, String city, Uf state, String zip) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Uf getState() {
        return state;
    }

    public void setState(Uf state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}