package com.ideao.dev.javadatabase.supplier.dto;

import com.ideao.dev.javadatabase.supplier.Supplier;

public class SupplierDTO {
    private Long id;
    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;

    public SupplierDTO(Long id, String name, String street, String city, String state, String zip) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public SupplierDTO(Supplier supplier) {
        this.id = supplier.getId();
        this.name = supplier.getName();
        this.street = supplier.getStreet();
        this.city = supplier.getCity();
        this.state = supplier.getState();
        this.zip = supplier.getZip();
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

    public String getState() {
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