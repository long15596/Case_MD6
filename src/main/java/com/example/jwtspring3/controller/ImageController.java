package com.example.jwtspring3.controller;

import com.example.jwtspring3.model.Image;
import com.example.jwtspring3.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/images")
public class ImageController {
    @Autowired
    IImageService iImageService;
    @GetMapping
    public ResponseEntity<Iterable<Image>> findAll(Long propertyId) {
        return new ResponseEntity<>(iImageService.findAll(propertyId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Image> save(@RequestBody Image image) {
        return new ResponseEntity<>(iImageService.save(image), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Image> update(@PathVariable Long id, @RequestBody Image image) {
        image.setId(id);
        iImageService.save(image);
        return new ResponseEntity<>(image, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        iImageService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
