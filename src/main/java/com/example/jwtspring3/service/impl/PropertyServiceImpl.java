package com.example.jwtspring3.service.impl;

import com.example.jwtspring3.model.Property;
import com.example.jwtspring3.repository.PropertyRepository;
import com.example.jwtspring3.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PropertyServiceImpl implements IPropertyService {
    @Autowired
    PropertyRepository propertyRepository;
    @Override
    public void save(Property object) {
        propertyRepository.save(object);
    }

    @Override
    public void delete(Long id) {
        propertyRepository.deleteById(id);
    }

    @Override
    public Iterable<Property> findAll() {
        return propertyRepository.findAll();
    }

    @Override
    public Optional<Property> findById(Long id) {
        return propertyRepository.findById(id);
    }
}