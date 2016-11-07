package com.kpi.lab4;

import com.kpi.lab4.passengers.Passenger;
import com.kpi.lab4.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Road {
    public List<Vehicle<? extends Passenger>> carsInRoad = new ArrayList<>();

    public int getCountOfHumans() {
        return carsInRoad.stream()
                .mapToInt(Vehicle::getCurrentPassengersNumber)
                .sum();
    }

    public void addCarToRoad(Vehicle<? extends Passenger> car) {
        if (carsInRoad.contains(car)) return;
        carsInRoad.add(car);
    }
}
