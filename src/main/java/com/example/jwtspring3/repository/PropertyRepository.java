package com.example.jwtspring3.repository;

import com.example.jwtspring3.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
    Iterable<Property> findAllByUserId(Long id);
    Iterable<Property> findAllByNameContaining(String name);
    Iterable<Property> findAllByCategoryName(String name);
}
