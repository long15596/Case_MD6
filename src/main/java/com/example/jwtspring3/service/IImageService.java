package com.example.jwtspring3.service;

import com.example.jwtspring3.model.Image;

public interface IImageService extends GeneralService<Image>{
    Iterable<Image> findAll(Long id);
    Iterable<Image> findAllByPropertyId(Long id);
    void deleteAll(Iterable<Image> imageIterable);
    void deleteAllByPropertyId (Long id);
}
