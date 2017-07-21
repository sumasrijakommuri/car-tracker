package io.egen.Repository;

import io.egen.Entity.Alert;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AlertsRepoImplementation implements AlertsRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Object> getHighAlertCount() {
                return entityManager.createQuery("select vin,count(*) from Alert " +
                "where priority=\'High\' GROUP BY vin")
                .getResultList();
    }

    public List<Alert> getVehicleAlerts(String vehicleId) {
        return entityManager.createQuery("select alert from " +
                "Alert alert where vin =\'" +vehicleId +"\'").getResultList();
    }
}
