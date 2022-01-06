package com.example.demo.repsitories;

import com.example.demo.data.Pet;
import com.example.demo.data.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PetRepository extends MongoRepository<Pet, String> {
    List<Pet> findAllByUserId(String userId);

    Optional<Pet> findByUserIdAndName(String userId, String name);

    boolean existsByUserIdAndName(String userId, String name);
}
