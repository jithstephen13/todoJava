package com.todo.todo.repository;

import com.todo.todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositery extends JpaRepository<User, Integer> {
    User findByUsername(String Username);
    boolean existsByUsername(String username);

}
