package com.example.jwtspring3.service;


import com.example.jwtspring3.model.Role;

import java.util.Optional;

public interface RoleService {
    Iterable<Role> findAll();

    void save(Role role);

    Role findByName(String name);
    Role findById(Long id);
}
