package io.egen.Service;


import io.egen.Entity.Alert;

import java.util.List;

public interface AlertsService {


    public List<Object> getHighAlertCount();

    public List<Alert> getVehicleAlerts(String id);
}
