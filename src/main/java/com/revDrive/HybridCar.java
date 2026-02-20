package com.revDrive;

public class HybridCar extends Car {
    public int battery_range;
    public float mpg;

    public HybridCar(int car_id, String make, String model, int year, float price, int battery_range, float mpg){
        super(car_id, make, model, year, price);
        this.battery_range = battery_range;
        this.mpg = mpg;
    }

    @Override
    public String display_info(){
        String result = super.display_info();
        result += "\nBatteryRange: " + battery_range;
        result += "\nMillesPerGallon: " + mpg;
        return result;
    }
}
