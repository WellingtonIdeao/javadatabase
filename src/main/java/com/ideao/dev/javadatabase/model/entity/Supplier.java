package com.ideao.dev.javadatabase.model.entity;

public class Supplier {
    private long id;
    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;

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

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
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
        return "(" + id + ", " + name + ", " + street + ", " + city + ", " + state + ", " + zip + ")" ;
    }
}