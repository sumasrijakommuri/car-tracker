package io.egen.Service;

import io.egen.Entity.Vehicle;
import io.egen.Exception.ResourceNotFoundException;
import io.egen.Repository.VehicleRepositoryImplementation;
import org.dom4j.dom.DOMNodeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleServiceImplementation implements VehicleService{

    @Autowired
    VehicleRepositoryImplementation repository;

    @Transactional(readOnly = true)
    public List<Vehicle> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Vehicle findOne(String vehicleId) {
        Vehicle existing = repository.findOne(vehicleId);
        if(existing == null)
        {
            throw new ResourceNotFoundException("Vehicle with id "+ vehicleId + " doesn't exist.");
        }
        return existing;
    }

    @Transactional
    public Vehicle create(Vehicle vehicle) {
        return repository.create(vehicle);
    }

    @Transactional
    public List<Vehicle> update( List<Vehicle> vehicles) {

        return  repository.update(vehicles);
    }

    @Transactional
    public void delete(String vehicleId) {

        Vehicle exists = repository.findOne(vehicleId);
        if(exists == null)
        {
            throw new ResourceNotFoundException("The vehicle with id "+ vehicleId+ " doesn't exist.");
        }

        repository.delete(exists);

    }
}
