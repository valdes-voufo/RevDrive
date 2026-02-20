package com.revDrive;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarUtilTest
{

    @Test
    void testReadCSV() throws FileNotFoundException {
        //given
        URL resource = getClass().getClassLoader().getResource("cars.csv");
        assertNotNull(resource);
        String path = resource.getPath();

        //when
        List<List<String>> result = CarUtils.readCSV(path, ",");


        //then
        assertEquals(17, result.size());
        assertEquals("CarID", result.get(0).get(0));
        assertEquals("101", result.get(1).get(0));
    }
}