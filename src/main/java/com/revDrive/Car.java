package com.revDrive;

public  class Car {
    public int car_id;
    public String make;
    public String model;
    public int year;
    private float price;

    public Car(int car_id, String make, String model, int year, float price){
        this.car_id = car_id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public float getPrice(){
        return price;
    }

    public  String display_info(){
        String result = "CarID: " + car_id;
        result += "\nMake: " + make;
        result += "\nModel " + model;
        result += "\nYear: " + year;
        result += "\nPrice: " + price;
        return result;
    }

}