package io.egen.Service;

import io.egen.Entity.Readings;
import io.egen.Repository.ReadingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReadingServiceImplementation implements ReadingsService{
    @Autowired
    ReadingsRepository repository;



    @Transactional
    public Readings create(Readings readings) {

        return repository.create(readings);
    }

    public List<Readings> findAll(String vin, String signal) {
        return repository.findAll(vin,signal);
    }


}
