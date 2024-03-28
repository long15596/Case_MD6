package com.example.jwtspring3.controller;

import com.example.jwtspring3.model.Booking;
import com.example.jwtspring3.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    IBookingService bookingService;
    @GetMapping
    public ResponseEntity<Iterable<Booking>> findAll(Long userId, Long propertyId) {
        return new ResponseEntity<>(bookingService.findAll(userId, propertyId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Booking> save(@RequestBody Booking booking) {
        return new ResponseEntity<>(bookingService.save(booking), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Booking> update(@PathVariable Long id, @RequestBody Booking booking) {
        booking.setId(id);
        return new ResponseEntity<>(bookingService.save(booking), HttpStatus.OK);
    }
}
