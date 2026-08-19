package com.ideao.dev.javadatabase.model.entity;

public class Supplier {
    private long id;
    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;

    public Supplier() {}

    public Supplier(String name, String street, String city, String state, String zip) {
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

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getZip() {
        return zip;
    }

    @Override
    public String toString() {
        return "(" + id + ", " + name + ", " + street + ", " + city + ", " + state + ", " + zip + ")" ;
    }
}