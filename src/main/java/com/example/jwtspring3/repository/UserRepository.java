package com.example.jwtspring3.repository;



import com.example.jwtspring3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    List<User> findAllByRolesName(String roleName);
    List<User> findByNameContaining(String name);
    List<User> findByStatusContaining(String status);
    List<User> findByUsernameContaining(String username);
    List<User> findByNameContainingAndStatusContaining(String name, String status);
    Iterable<User> findByNameContainingAndUsernameContaining(String name, String username);
    Iterable<User> findByStatusContainingAndUsernameContaining(String status, String username);
    List<User> findByNameContainingAndStatusContainingAndUsernameContaining(String name, String status, String username);
    Iterable<User> findByRolesNameNot(String roleAdmin);
}