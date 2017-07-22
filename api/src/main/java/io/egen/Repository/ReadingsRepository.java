package io.egen.Repository;

import io.egen.Entity.Readings;

import java.util.List;


public interface ReadingsRepository {

    Readings create(Readings readings);
    List<Readings> findAll(String vin, String signal);

}
