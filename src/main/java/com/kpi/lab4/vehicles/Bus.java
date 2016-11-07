package com.kpi.lab4.vehicles;

import com.kpi.lab4.passengers.Passenger;

public class Bus extends Vehicle<Passenger> {

    public int getMaxPassengersNumber() {
        return 20;
    }
}
