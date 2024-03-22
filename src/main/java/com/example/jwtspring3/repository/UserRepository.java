package com.example.jwtspring3.repository;
import com.example.jwtspring3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    Iterable<User> findAllByRolesName(String roleName);
    Iterable<User> findByNameContainingAndRolesIdNot(String name, Long id);
    Iterable<User> findByUsernameContainingAndRolesIdNot(String username, Long id);
    Iterable<User> findByStatusAndRolesIdNot(String status, Long id);;
    Iterable<User>findByNameContainingAndUsernameContainingAndRolesIdNot(String name, String username, Long id);
    Iterable<User> findByRolesIdNot(Long id);
}