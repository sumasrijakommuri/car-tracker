package io.egen.Repository;


import io.egen.Entity.Vehicle;

import java.util.List;

public interface VehicleRepository {
    List<Vehicle> findAll();
    Vehicle findOne(String id);
    Vehicle create(Vehicle vehicle);
    List<Vehicle> update(List<Vehicle> vehicles);
    void delete(Vehicle vehicle);
}
