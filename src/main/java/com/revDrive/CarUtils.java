package com.revDrive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarUtils {

    public static List<List<String>> readCSV(String file,String COMMA_DELIMITER) throws FileNotFoundException {
        List<List<String>> records = new ArrayList<>();
        try (
                Scanner scanner = new Scanner(new File(file))) {
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

}