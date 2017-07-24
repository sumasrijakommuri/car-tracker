package io.egen.Service;

import io.egen.Entity.Readings;

import java.util.List;


public interface ReadingsService {

   Readings create(Readings readings);
   List<Readings> findAll(String vin, String signal);
   List<Object> getLocation(String id);
}
