package com.example.jwtspring3.controller;

import com.example.jwtspring3.model.Category;
import com.example.jwtspring3.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    ICategoryService iCategoryService;
    @GetMapping
    public ResponseEntity<Iterable<Category>> findAll() {
        return new ResponseEntity<>(iCategoryService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Category> save(@RequestBody Category category) {
        iCategoryService.save(category);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }
}
