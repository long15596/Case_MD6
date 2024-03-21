package com.example.jwtspring3.service.impl;

import com.example.jwtspring3.model.Image;
import com.example.jwtspring3.repository.ImageRepository;
import com.example.jwtspring3.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class IImageServiceImpl implements IImageService {
    @Autowired
    ImageRepository imageRepository;
    @Override
    public void save(Image object) {
        imageRepository.save(object);
    }

    @Override
    public void delete(Long id) {
        imageRepository.deleteById(id);
    }

    @Override
    public Iterable<Image> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public Iterable<Image> findAll(Long id) {
        if(id != -1) {
            return imageRepository.findByPropertyId(id);
        }
        return imageRepository.findAll();
    }

    @Override
    public Optional<Image> findById(Long id) {
        return imageRepository.findById(id);
    }

    @Override
    public Iterable<Image> findAllByPropertyId(Long id) {
        return imageRepository.findByPropertyId(id);
    }

    @Override
    public void deleteAll(Iterable<Image> imageIterable) {
        imageRepository.deleteAll(imageIterable);
    }

    @Override
    public void deleteAllByPropertyId(Long id) {
        imageRepository.deleteAllByPropertyId(id);
    }
}
