package io.egen.Repository;

import io.egen.Entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class VehicleRepositoryImplementation implements VehicleRepository{

    @PersistenceContext
    EntityManager entityManager;


    public List<Vehicle> findAll() {
        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.findAll",Vehicle.class);
        return query.getResultList();
    }

    public Vehicle findOne(String id) {
        return entityManager.find(Vehicle.class,id);
    }

    public Vehicle create(Vehicle vehicle) {
        entityManager.persist(vehicle);
        return vehicle;
    }

    public List<Vehicle> update(List<Vehicle> vehicles) {
        for(Vehicle v:vehicles) {
            Vehicle exists = entityManager.find(Vehicle.class, v.getVin());
            if(exists == null)
            {
                entityManager.persist(v);
            }
            else
            {
                entityManager.merge(v);
            }

        }
        return vehicles;
    }

    public void delete(Vehicle vehicle) {
        entityManager.remove(vehicle);
    }
}
