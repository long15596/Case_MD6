package com.example.jwtspring3.controller;

import com.example.jwtspring3.model.Location;
import com.example.jwtspring3.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/locations")
public class LocationController {
    @Autowired
    ILocationService iLocationService;
    @GetMapping
    public ResponseEntity<Iterable<Location>> findAll() {
        return new ResponseEntity<>(iLocationService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Location> save(@RequestBody Location location) {
        return new ResponseEntity<>(iLocationService.save(location), HttpStatus.CREATED);
    }
}
