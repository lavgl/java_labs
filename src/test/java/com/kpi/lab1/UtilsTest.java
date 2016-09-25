package com.kpi.lab1;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class UtilsTest {
    String[] arr = {
            "one",   // 3
            "two",   // 3
            "three", // 5
            "four",  // 4
            "five",  // 4
            "six",   // 3
            "seven", // 5
            "eight", // 5
            "nine",  // 4
            "ten" }; // 3
                     // avg = 3.9
    double EXPECTED_AVERAGE = 3.9;
    double DELTA = 0.01;

    List<String> strings = new ArrayList<>(Arrays.asList(arr));

    @Test
    public void averageTest() {
        double avg = Utils.average(strings);
        Assert.assertEquals(EXPECTED_AVERAGE, avg, DELTA);
    }

    @Test
    public void moreThenAverageTest() {
        List expectedList = strings
                .stream()
                .filter(str -> str.length() > EXPECTED_AVERAGE)
                .collect(toList());

        List filteredList = Utils.moreThenAverage(strings);

        Assert.assertEquals(expectedList, filteredList);
    }

    @Test
    public void lessEqualThenAverage() {
        List expectedList = strings
                .stream()
                .filter(str -> str.length() <= EXPECTED_AVERAGE)
                .collect(toList());

        List filteredList = Utils.lessEqualThenAverage(strings);

        Assert.assertEquals(expectedList, filteredList);
    }
}
