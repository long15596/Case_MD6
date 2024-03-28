package com.example.jwtspring3.service;

import com.example.jwtspring3.model.Booking;

public interface IBookingService extends GeneralService<Booking> {
    Iterable<Booking> findAll(Long userId, Long propertyId);
}
