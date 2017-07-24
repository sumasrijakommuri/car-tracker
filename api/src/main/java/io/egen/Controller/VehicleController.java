package io.egen.Controller;

import io.egen.Entity.Vehicle;
import io.egen.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
public class VehicleController {

    @Autowired
    VehicleService service;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/vehicles", produces = APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> findAll(){
        return service.findAll();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET,value = "/vehicles/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public Vehicle findOne(@PathVariable("id") String vehicleId){
        return service.findOne(vehicleId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/vehicles",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public Vehicle create(@RequestBody Vehicle vehicle)
    {
        return service.create(vehicle);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, value="/vehicles", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> update(@RequestBody List<Vehicle> vehicles)
    {
        return service.update(vehicles);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/vehicles/{id}", consumes = APPLICATION_JSON_UTF8_VALUE)
    public void delete(@PathVariable("id") String vehicleId)
    {
        service.delete(vehicleId);
    }
}
