package com.revDrive;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarUtils {

    public static List<List<String>> readCSV(String file,String COMMA_DELIMITER) throws FileNotFoundException {
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(file))) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine(), COMMA_DELIMITER));
            }
        }

        return records;
    }


    private static List<String> getRecordFromLine(String line, String COMMA_DELIMITER) {
        List<String> values = new ArrayList<>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

    public static List<Car> getCarDirectory(String filename) {
        ArrayList<Car> cars = new ArrayList<>();

        List<List<String>> records;
        try {
            records = readCSV(filename, ",");
        }catch (Exception e) {
            System.out.println("Exception occurred while reading CSV car data. Aborting function and returning null.");
            return null;
        }
        for(int i = 1 ; i < records.size(); i++) {
            List<String> record = records.get(i);
            if (record.size() != 8) {
                System.out.println("Wrong format of CSV.Should have 8 columns. Returning null");
                return null;
            }
            // CarID,Make,Model,Year,Price,Type,BatteryRange,MPG
            if (record.get(i).equals("Electric")) {
                cars.add(new ElectricCar(Integer.parseInt(record.get(0)),
                        record.get(1), record.get(2), Integer.parseInt(record.get(3)),
                        Float.parseFloat(record.get(4)), Integer.parseInt(record.get(6))));
            } else if (record.get(i).equals("Gasoline")) {
                cars.add(new GasolineCar(Integer.parseInt(record.get(0)),
                        record.get(1), record.get(2), Integer.parseInt(record.get(3)),
                        Float.parseFloat(record.get(4)), Float.parseFloat(record.get(6))));
            } else if (record.get(i).equals("Hybrid")) {
                cars.add(new HybridCar(Integer.parseInt(record.get(0)),
                        record.get(1), record.get(2), Integer.parseInt(record.get(3)),
                        Float.parseFloat(record.get(4)), Integer.parseInt(record.get(6)),
                        Float.parseFloat(record.get(7))));
            } else if (record.get(i).equals("Car")) {
                cars.add(new Car(Integer.parseInt(record.get(0)),
                        record.get(1), record.get(2), Integer.parseInt(record.get(3)),
                        Float.parseFloat(record.get(4))));
            } else {
                System.out.println("Wrong format of CSV. Cartype was not detected. Car will be skipped");
            }
        }

        return cars;

    }



}