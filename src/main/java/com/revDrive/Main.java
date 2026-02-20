package com.revDrive;

import javax.print.attribute.standard.PrinterInfo;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    //delivery information for each others
    public static void printOderInformations( ){
        List<List<String>> orders = new ArrayList<>();
         try {
            orders = CarUtils.readCSV("src/main/resources/orders.csv",",");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (List<String> oder:orders){
            System.out.println("Oder:"+oder.get(0) +"the order will be delivered by "+oder.get(5));
        }
    }

    public static void main(String[] args) {
        printOderInformations();
        printDealershipInformations();
    }



    //Dealership inventory
    public  static  void printDealershipInformations(){
        CarDealership c = new CarDealership();
        for (CarDealership carDealership:c.createDealership()){

            System.out.println("Dealership:"+carDealership.getId() +"Cars:"+carDealership.getInventory().stream().map(Car::getCar_id).collect(Collectors.toSet()));
        }
    }
}
