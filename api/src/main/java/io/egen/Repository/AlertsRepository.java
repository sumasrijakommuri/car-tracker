package io.egen.Repository;

import io.egen.Entity.Alert;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AlertsRepository {

    public List<Object> getHighAlertCount();

    public List<Alert> getVehicleAlerts(String vehicleId);
}
