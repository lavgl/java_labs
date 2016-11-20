package com.kpi.lab9;

import java.util.Random;
import java.util.concurrent.Callable;

public class ParallelMonteCarloPi implements Callable<Double> {
    private int totalCount;
    private int positiveCount = 0;
    private String name;

    public ParallelMonteCarloPi(String name, int count) {
        this.totalCount = count;
        Thread.currentThread().setName(name);
        this.name = Thread.currentThread().getName();
    }

    public ParallelMonteCarloPi(int count) {
        this.totalCount = count;
        this.name = Thread.currentThread().getName();
    }

    @Override
    public Double call() throws Exception {
        Random generator = new Random();
        for (int i = 0; i < this.totalCount; i++) {
            float x = generator.nextFloat();
            float y = generator.nextFloat();
            double range = Math.sqrt(x * x + y * y);
            if (range <= 1) {
                this.positiveCount++;
            }
        }
        Double result = (double)this.positiveCount / this.totalCount;
        return result;
    }
}
