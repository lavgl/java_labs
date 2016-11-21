package com.kpi.lab5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CounterTest {
    List<String> lines = new ArrayList<>();

    @Before
    public void init() {
        lines.add("1");
        lines.add("2 2");
        lines.add("3 3 3");
        lines.add("5 5 5 5 5");
        lines.add("4 4 4 4");
    }

    @Test
    public void findTheLongestLineTest() {
        String theLongestLine = Counter.findTheLongestLine(lines);
        Assert.assertEquals(lines.get(3), theLongestLine);
    }
}
