package com.example.jwtspring3.repository;
import com.example.jwtspring3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    List<User> findAllByRolesName(String roleName);
    List<User> findByNameContainingAndRolesNameNot(String name, String roleName);
    Iterable<User> findByUsernameContainingAndRolesNameNot(String username, String roleName);
    List<User> findByStatusAndRolesNameNot(String status, String roleName);;
    Iterable<User>findByNameContainingAndUsernameContainingAndRolesNameNot(String name, String username, String roleName);
    Iterable<User> findByRolesNameNot(String roleAdmin);
}