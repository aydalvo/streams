package com.mystreams.main;

import com.mystreams.dominio.CarBrand;
import com.mystreams.dominio.Vehicle;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MinhaClasse2 {

    private static List<Vehicle> myVehicles= new ArrayList<>(List.of(
            new Vehicle(CarBrand.FORD.name(), "F-150", 2.0)
            , new Vehicle(CarBrand.FORD.name(), "Mustang", 2.1)
            , new Vehicle(CarBrand.GM.name(), "Camaro", 2.1)
            , new Vehicle(CarBrand.GM.name(), "Suburban", 2.2)
            , new Vehicle(CarBrand.TESLA.name(), "X", 2.5)
            , new Vehicle(CarBrand.TESLA.name(), "Cyber truck", 2.9)
            , new Vehicle(CarBrand.MB.name(), "CLA", 2.1)
        )
    );

    public static void main(String [] args) {
        Map<String, DoubleSummaryStatistics> collect = myVehicles.stream()
                .collect(Collectors.groupingBy(Vehicle::getBrand, Collectors.summarizingDouble(Vehicle::getPrice)));
        System.out.println(collect);
    }
}
