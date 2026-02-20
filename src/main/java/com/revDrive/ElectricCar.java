package com.revDrive;

public class ElectricCar extends Car {
    public int battery_range;

    public ElectricCar(int car_id, String make, String model, int year, float price, int battery_range){
        super(car_id, make, model, year, price);
        this.battery_range = battery_range;
    }

    @Override
    public String display_info(){
        String result = super.display_info();
        result += "\nBatteryRange: " + battery_range;
        return result;
    }
}
