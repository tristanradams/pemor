package com.example.demo.repsitories;

import com.example.demo.data.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    boolean existsByUsername(String username);

    boolean existsByDetails_Email(String email);

    Optional<User> findByUsername(String username);

    Optional<User> findByDetails_Email(String email);
}
