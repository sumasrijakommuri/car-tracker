package io.egen.Controller;

import io.egen.Entity.Readings;
import io.egen.Service.ReadingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
public class ReadingsController {

    @Autowired
    ReadingsService service;


    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value="/readings",produces= APPLICATION_JSON_UTF8_VALUE, consumes = APPLICATION_JSON_UTF8_VALUE)
    public Readings create(@RequestBody Readings readings)
    {
        return service.create(readings);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/readings/{id}/{signal}", produces = APPLICATION_JSON_UTF8_VALUE)
    public List<Readings> findAll(@PathVariable("id") String vin,@PathVariable("signal") String signal){
        return service.findAll(vin,signal);
    }


}
