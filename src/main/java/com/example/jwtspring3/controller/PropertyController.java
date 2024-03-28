package com.example.jwtspring3.controller;

import com.example.jwtspring3.model.Property;
import com.example.jwtspring3.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/properties")
public class PropertyController {
    @Autowired
    IPropertyService iPropertyService;
    @GetMapping
    public ResponseEntity<Iterable<Property>> findAll(Long userId, String name, String categoryName, String locationName, Long priceStart, Long priceEnd, Long bedroomStar, Long bedroomEnd, Long bathroomStart, Long bathroomEnd, Long livingRoomStart, Long livingRoomEnd) {
        return new ResponseEntity<>(iPropertyService.findAll(userId, name, categoryName, locationName, priceStart, priceEnd, bedroomStar, bedroomEnd, bathroomStart, bathroomEnd, livingRoomStart, livingRoomEnd), HttpStatus.OK);
    }
    @GetMapping("/owners/{id}")
    public ResponseEntity<Iterable<Property>> findPropertyByUser(@PathVariable Long id , String name, String categoryName, String locationName){
        return new ResponseEntity<>(iPropertyService.findAllPropertyByOwner(id,name,categoryName,locationName),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Property> save(@RequestBody Property property) {
        return new ResponseEntity<>(iPropertyService.save(property), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Property> update(@PathVariable Long id, @RequestBody Property property) {
        property.setId(id);
        iPropertyService.save(property);
        return new ResponseEntity<>(property, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        iPropertyService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
