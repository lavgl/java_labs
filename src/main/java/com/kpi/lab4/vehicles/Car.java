package com.kpi.lab4.vehicles;

import com.kpi.lab4.passengers.Passenger;

public class Car<P extends Passenger> extends Vehicle<P> {

    @Override
    public int getMaxPassengersNumber() {
        return 3;
    }
}
