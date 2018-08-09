package io.egen.Controller;


import io.egen.Entity.Alert;
import io.egen.Service.AlertsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
public class AlertsController {

    @Autowired
    AlertsService service;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value="/alertnumbers", produces = APPLICATION_JSON_UTF8_VALUE)
    public List<Object> getHighAlertCount(){
        return service.getHighAlertCount();
    }

    //Testing git
    
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value="/vehiclealerts/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public List<Alert> getVehicleAlerts(@PathVariable("id") String vehicleId){
        return service.getVehicleAlerts(vehicleId);
    }
}
