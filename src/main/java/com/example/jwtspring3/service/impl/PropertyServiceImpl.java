package com.example.jwtspring3.service.impl;

import com.example.jwtspring3.model.Image;
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
    @Autowired
    IImageServiceImpl iImageService;

    @Override
    public Property save(Property object) {
        return propertyRepository.save(object);
    }

    @Override
    public void delete(Long id) {
        Iterable<Image> imageIterable = iImageService.findAllByPropertyId(id);
        iImageService.deleteAll(imageIterable);
        propertyRepository.deleteById(id);
    }

    @Override
    public Iterable<Property> findAll() {
        return propertyRepository.findAll();
    }

    @Override
    public Iterable<Property> findAll(String name, String categoryName, String locationName, Long priceStart, Long priceEnd, Long bedroomStar, Long bedroomEnd, Long bathroomStart, Long bathroomEnd, Long livingRoomStart, Long livingRoomEnd) {
        if (name != null && categoryName != null && locationName != null) {
            return propertyRepository.findByNameContainingAndCategoryNameAndLocationName(name, categoryName, locationName);
        } else if (name != null && categoryName != null) {
            return propertyRepository.findByNameContainingAndCategoryName(name, categoryName);
        } else if (name != null && locationName != null) {
            return propertyRepository.findByNameContainingAndLocationName(name, locationName);
        } else if (categoryName != null && locationName != null) {
            return propertyRepository.findByCategoryNameAndLocationName(categoryName, locationName);
        } else if (name != null) {
            return propertyRepository.findAllByNameContaining(name);
        } else if (categoryName != null) {
            return propertyRepository.findAllByCategoryName(categoryName);
        } else if (locationName != null) {
            return propertyRepository.findAllByLocationName(locationName);
        } else if (priceStart != null && priceEnd != null) {
            return propertyRepository.findAllByPriceBetween(priceStart, priceEnd);
        } else if (bathroomStart != null && bathroomEnd != null) {
            return propertyRepository.findAllByBathroomBetween(bathroomStart, bathroomEnd);
        } else if (bedroomStar != null && bedroomEnd != null) {
            return propertyRepository.findAllByBedroomBetween(bedroomStar, bedroomEnd);
        } else if (livingRoomStart != null && livingRoomEnd != null) {
            return propertyRepository.findByLivingRoomBetween(livingRoomStart, livingRoomEnd);
        }
        return propertyRepository.findAll();
    }

    @Override
    public Iterable<Property> findAllPropertyByOwner(Long id, String name, String categoryName, String locationName) {
        if (name != null && categoryName != null) {
            return propertyRepository.findByNameContainingAndCategoryName(name, categoryName);
        } else if (name != null && locationName != null) {
            return propertyRepository.findByNameContainingAndLocationName(name, locationName);
        } else if (categoryName != null && locationName != null) {
            return propertyRepository.findByCategoryNameAndLocationName(categoryName, locationName);
        } else if (name != null) {
            return propertyRepository.findAllByNameContainingAndUserId(name, id);
        } else if (categoryName != null) {
            return propertyRepository.findAllByCategoryName(categoryName);
        } else if (locationName != null) {
            return propertyRepository.findAllByLocationName(locationName);
        }
        return propertyRepository.findAllByUserId(id);
    }

    @Override
    public Optional<Property> findById(Long id) {
        return propertyRepository.findById(id);
    }
}