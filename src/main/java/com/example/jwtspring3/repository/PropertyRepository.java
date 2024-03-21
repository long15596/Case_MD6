package com.example.jwtspring3.repository;

import com.example.jwtspring3.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
    Iterable<Property> findAllByUserId(Long id);
    Iterable<Property> findAllByNameContaining(String name);
    Iterable<Property> findAllByCategoryName(String name);
    Iterable<Property> findAllByLocationName(String name);
    Iterable<Property> findByNameContainingAndCategoryNameAndLocationName(String name, String categoryName, String locationName);
    Iterable<Property> findByNameContainingAndCategoryName(String name, String categoryName);
    Iterable<Property> findByNameContainingAndLocationName(String name, String locationName);
    Iterable<Property> findByCategoryNameAndLocationName(String categoryName, String locationName);
    Iterable<Property> findAllByPriceBetween(Long startNum, Long endNum);
    Iterable<Property> findAllByBedroomBetween(Long startNum, Long endNum);
    Iterable<Property> findAllByBathroomBetween(Long startNum, Long endNum);
    Iterable<Property> findByLivingRoomBetween(Long startNum, Long endNum);
}
