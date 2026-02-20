package com.revDrive;

import java.util.ArrayList;
import java.util.List;


public class CarDealership {
      private  String id;
      private  String name;
      private  String locJson;
      private List<Car> inventory;



      public void addCar( Car car){
          this.inventory.add(car);
      }


      public List<String> displayCarInfos(){

          return  new ArrayList<>();
      }


}


