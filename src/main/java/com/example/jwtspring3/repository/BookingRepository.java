package com.example.jwtspring3.repository;

import com.example.jwtspring3.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    Iterable<Booking> findByUserId(Long id);
    Iterable<Booking> findByPropertyId(Long id);
}
