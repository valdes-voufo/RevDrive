package com.revDrive;

public class GasolineCar extends Car {
    public float mpg;

    public GasolineCar(int car_id, String make, String model, int year, float price, float mpg){
        super(car_id, make, model, year, price);
        this.mpg = mpg;
    }

    @Override
    public String display_info(){
        String result = super.display_info();
        result += "\nMillesPerGallon: " + mpg;
        return result;
    }
}
