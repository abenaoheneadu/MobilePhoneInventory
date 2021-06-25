package com.dynamicdevz.mobilephonesinventory.model.data;

public class Phone {
    private int phoneId;
    private String name;
    private String manufacturer;
    private String model;
    private double price;


    public Phone(int phoneId, String name, String manufacturer, String model, double price) {
        this.phoneId = phoneId;
        this.name = name;
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
    }

    public int getPhoneId() {
        return phoneId;
    }

    public Phone(String name, String manufacturer, String model, double price) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }
}
