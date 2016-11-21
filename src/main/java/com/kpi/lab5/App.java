package com.kpi.lab5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Path path = Paths.get("Fight Club.txt");
        List<String> lines = Reader.read(path);

        String theLongestLine = Counter.findTheLongestLine(lines);

        System.out.println("The longest line: " + theLongestLine);
    }
}
