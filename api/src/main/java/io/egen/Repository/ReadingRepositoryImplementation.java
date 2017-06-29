package io.egen.Repository;


import io.egen.Entity.Alert;
import io.egen.Entity.Readings;
import io.egen.Entity.Tires;
import io.egen.Entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



@Repository
public class ReadingRepositoryImplementation implements ReadingsRepository {

    @PersistenceContext
    EntityManager entityManager;



    public Readings create(Readings readings) {


        Tires tires = readings.getTires();

        float engineRpm = readings.getEngineRpm();
        Vehicle vehicle = entityManager.find(Vehicle.class,readings.getVin());
        float redlineRpm = vehicle.getRedlineRpm();

        if(engineRpm > redlineRpm)
        {
            Alert alert = new Alert();
            alert.setPriority("High");
            alert.setType("RPM exceeded");
            alert.setVin(readings.getVin());
            alert.setTimestamp(readings.getTimestamp());

            entityManager.persist(alert);
        }

        double fuelLimit = (0.1)*(vehicle.getMaxFuelVolume());
        if(readings.getFuelVolume()< fuelLimit)
        {
            Alert alert = new Alert();
            alert.setPriority("Medium");
            alert.setType("Low Fuel");
            alert.setVin(readings.getVin());
            alert.setTimestamp(readings.getTimestamp());

            entityManager.persist(alert);
        }

        float totalPressure = tires.getFrontLeft() + tires.getFrontRight() + tires.getRearLeft() + tires.getRearRight();
        if(totalPressure < 128 || totalPressure > 144 )
        {
            Alert alert = new Alert();
            alert.setPriority("Low");
            alert.setType("Tire Pressure");
            alert.setVin(readings.getVin());
            alert.setTimestamp(readings.getTimestamp());

            entityManager.persist(alert);
        }

        if(readings.isEngineCoolantLow() || readings.isCheckEngineLightOn())
        {
            Alert alert = new Alert();
            alert.setPriority("Low");
            alert.setType("Engine Coolant or Engine Light");
            alert.setVin(readings.getVin());
            alert.setTimestamp(readings.getTimestamp());

            entityManager.persist(alert);
        }

        entityManager.persist(tires);
        readings.setTires(tires);
        entityManager.persist(readings);


        return readings;
    }


}
