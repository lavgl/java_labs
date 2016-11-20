package com.kpi.lab9;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final int ITERATION_COUNT = 1000000000;
        final int THREADS = 4;

        CountRunner counter = new CountRunner();

        long begin = System.currentTimeMillis();
        double PI = counter.countPI(THREADS, ITERATION_COUNT);
        long end = System.currentTimeMillis() - begin;

        StringBuilder output = new StringBuilder()
                .append("PI: " + PI + '\n')
                .append("Threads: " + THREADS + '\n')
                .append("ITERATIONS: " + ITERATION_COUNT + '\n')
                .append("TIME: " + end + "ms");

        System.out.println(output);
    }
}
