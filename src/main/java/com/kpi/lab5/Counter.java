package com.kpi.lab5;

import java.util.*;
import java.util.stream.Collectors;

public class Counter {
    public static List<Integer> countWords(List<String> lines) {
        return lines.stream()
                .mapToInt(s -> s.split(" ").length)
                .boxed()
                .collect(Collectors.toList());
    }

    public static int findTheLongestLineIndex(List<String> lines) {
        List<Integer> wordsCount = countWords(lines);
        int maxLength = Collections.max(wordsCount);
        return wordsCount.indexOf(maxLength);
    }

    public static String findTheLongestLine(List<String> lines) {
        int index = findTheLongestLineIndex(lines);
        return lines.get(index);
    }
}
