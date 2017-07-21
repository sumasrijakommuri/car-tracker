package io.egen.Service;

import io.egen.Entity.Alert;
import io.egen.Repository.AlertsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertsServiceImplementation implements AlertsService {

    @Autowired
    AlertsRepository repository;

    public List<Object> getHighAlertCount() {
        return repository.getHighAlertCount();
    }

    public List<Alert> getVehicleAlerts(String id) {
        return repository.getVehicleAlerts(id);
    }
}
