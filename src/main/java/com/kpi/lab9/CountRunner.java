package com.kpi.lab9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountRunner {

    public double countPI(int threadCount, int iterationCount) {
        ExecutorService executor = Executors.newWorkStealingPool();
        List<Callable<Double>> callables = new ArrayList<>();
        double result = 0;

        for (int i = 0; i < threadCount; i++) {
            callables.add(new ParallelMonteCarloPi(i + " thread", iterationCount / threadCount));
        }

        try {
            result = executor.invokeAll(callables)
                    .stream()
                    .mapToDouble(future -> {
                        try {
                            return future.get();
                        } catch (Exception e) {
                            throw new IllegalStateException(e);
                        }
                    })
                    .sum() / threadCount;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result * 4;

    }
}
