package com.example.jwtspring3.service.impl;

import com.example.jwtspring3.model.Location;
import com.example.jwtspring3.repository.LocationRepository;
import com.example.jwtspring3.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationServiceImpl implements ILocationService {
    @Autowired
    LocationRepository locationRepository;
    @Override
    public void save(Location object) {
        locationRepository.save(object);
    }

    @Override
    public void delete(Long id) {
        locationRepository.deleteById(id);
    }

    @Override
    public Iterable<Location> findAll() {
        return locationRepository.findAll();
    }

    @Override
    public Optional<Location> findById(Long id) {
        return locationRepository.findById(id);
    }
}
