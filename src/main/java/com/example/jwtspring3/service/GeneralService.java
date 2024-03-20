package com.example.jwtspring3.service;

import java.util.Optional;

public interface GeneralService<O> {
    void save(O o);
    void delete(Long id);
    Iterable<O> findAll();
    Optional<O> findById(Long id);
}
