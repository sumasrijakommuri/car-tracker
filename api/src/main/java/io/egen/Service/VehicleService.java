package io.egen.Service;

import io.egen.Entity.Vehicle;

import java.util.List;

public interface VehicleService {

    List<Vehicle> findAll();
    Vehicle findOne(String vehicleId);
    Vehicle create(Vehicle vehicle);
    List<Vehicle> update(List<Vehicle> vehicles);
    void delete(String vehicleId);
}
