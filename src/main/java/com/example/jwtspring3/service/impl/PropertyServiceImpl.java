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
    public void save(Property object) {
        propertyRepository.save(object);
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
        if (name != null &&  categoryName != null && locationName != null) {
            propertyRepository.findByNameContainingAndCategoryNameAndLocationName(name, categoryName, locationName);
        } else if (name != null && categoryName != null) {
            propertyRepository.findByNameContainingAndCategoryName(name, categoryName);
        } else if (name != null && locationName != null) {
            propertyRepository.findByNameContainingAndLocationName(name, locationName);
        } else if (categoryName != null && locationName != null) {
            propertyRepository.findByCategoryNameAndLocationName(categoryName, locationName);
        } else if (name != null) {
            propertyRepository.findAllByNameContaining(name);
        } else if (categoryName != null) {
            propertyRepository.findAllByCategoryName(categoryName);
        } else if (locationName != null) {
            propertyRepository.findAllByLocationName(locationName);
        } else if (priceStart != -1 && priceEnd != -1) {
            propertyRepository.findAllByPriceBetween(priceStart, priceEnd);
        } else if (bathroomStart != -1 && bathroomEnd != -1) {
            propertyRepository.findAllByBathroomBetween(bathroomStart, bathroomEnd);
        } else if (bedroomStar != -1 && bedroomEnd != -1) {
            propertyRepository.findAllByBedroomBetween(bedroomStar, bedroomEnd);
        } else if (livingRoomStart != -1 && livingRoomEnd != -1) {
            propertyRepository.findByLivingRoomBetween(livingRoomStart, livingRoomEnd);
        }
        return propertyRepository.findAll();
    }
    @Override
    public Optional<Property> findById(Long id) {
        return propertyRepository.findById(id);
    }


}