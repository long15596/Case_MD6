package com.example.jwtspring3.service;

import java.util.Optional;

public interface GeneralService<Object> {
    void save(Object object);
    void delete(Long id);
    Iterable<Object> findAll();
    Optional<Object> findById(Long id);
}
