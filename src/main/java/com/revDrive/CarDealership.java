package com.revDrive;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.revDrive.CarUtils.getCarDirectory;


public class CarDealership {
    private int id;
    private String name;
    private String locJson;
    private List<Car> inventory;


    public void addCar(Car car) {
        this.inventory.add(car);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocJson() {
        return locJson;
    }

    public void setLocJson(String locJson) {
        this.locJson = locJson;
    }

    public List<Car> getInventory() {
        return inventory;
    }

    public void setInventory(List<Car> inventory) {
        this.inventory = inventory;
    }

    public List<String> displayCarInfos() {

        List<String> result = new ArrayList<>();
        for (Car car : inventory) {
            result.add(car.display_info());
        }

        return result;
    }

    public List<CarDealership> createDealership() {

        // MUST be loaded from somewhere
        Map<Integer,Car> cars = getCarDirectory("src/main/resources/cars.csv"); // example method

        List<List<String>> carDealership;

        try {
            carDealership = CarUtils.readCSV("src/main/resources/orders.csv", ",");
        } catch (FileNotFoundException e) {
            System.out.println("problem by reading the orders");
            throw new RuntimeException(e);
        }

        Map<Integer, CarDealership> dealershipMap = new HashMap<>();

        for ( int i = 1 ; i<= carDealership.size(); i++) {
           List<String> deal = carDealership.get(i);
            Integer id = Integer.parseInt(deal.get(1));
            Integer carIndex = Integer.parseInt(deal.get(4));

            CarDealership c;

            if (!dealershipMap.containsKey(id)) {

                c = new CarDealership();
                c.setId(id);
                c.setName(deal.get(2));
                c.setLocJson(deal.get(3));

                // IMPORTANT initialize inventory
                c.inventory = new ArrayList<>();

                dealershipMap.put(id, c);

            } else {
                c = dealershipMap.get(id);
            }

            // add Car
            c.inventory.add(cars.get(carIndex));
        }

        return new ArrayList<>(dealershipMap.values());
    }

}


