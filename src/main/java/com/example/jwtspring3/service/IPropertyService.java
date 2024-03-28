package com.example.jwtspring3.service;

import com.example.jwtspring3.model.Property;

public interface IPropertyService extends GeneralService<Property>{
    Iterable<Property> findAll(String name, String categoryName, String locationName, Long priceStart, Long priceEnd, Long bedroomStar, Long bedroomEnd, Long bathroomStart, Long bathEnd, Long livingRoomStart, Long livingRoomEnd);
    Iterable<Property> findAllPropertyByOwner(Long id , String name, String categoryName, String locationName);
}
