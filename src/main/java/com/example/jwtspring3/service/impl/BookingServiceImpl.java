package com.example.jwtspring3.service.impl;

import com.example.jwtspring3.model.Booking;
import com.example.jwtspring3.repository.BookingRepository;
import com.example.jwtspring3.service.IBookingService;
import com.example.jwtspring3.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BookingServiceImpl implements IBookingService {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    IPropertyService iPropertyService;
    @Override
    public Booking save(Booking object) {

        object.setTotalAmount(object.getTotalDay() * iPropertyService.findById(object.getProperty().getId()).get().getPrice());
        return bookingRepository.save(object);
    }

    @Override
    public void delete(Long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public Iterable<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Optional<Booking> findById(Long id) {
        return bookingRepository.findById(id);
    }

    @Override
    public Iterable<Booking> findAll(Long userId, Long propertyId) {
        if (userId != null) {
            return bookingRepository.findByUserId(userId);
        } else if (propertyId != null) {
            return bookingRepository.findByPropertyId(propertyId);
        }
        return bookingRepository.findAll();
    }
}
