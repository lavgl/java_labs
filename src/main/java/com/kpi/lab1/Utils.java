package com.kpi.lab1;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Utils {
    public static double average(List<String> strings) {
        return strings
                .stream()
                .mapToInt(String::length)
                .average()
                .getAsDouble();

    }

    public static List<String> moreThenAverage(List<String> strings) {
        double avg = average(strings);

        return strings
                .stream()
                .filter(str -> str.length() > avg)
                .collect(toList());
    }

    public static List<String> lessEqualThenAverage(List<String> strings) {
        double avg = average(strings);

        return strings
                .stream()
                .filter(str -> str.length() <= avg)
                .collect(toList());
    }
}
