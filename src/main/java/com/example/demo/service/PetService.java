package com.example.demo.service;

import com.example.demo.data.Pet;
import com.example.demo.data.User;
import com.example.demo.functions.PetFuns;
import com.example.demo.repsitories.PetRepository;
import com.example.demo.repsitories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    PetRepository repo;
    PetFuns funs;

    @Autowired
    public PetService(PetRepository repo, PetFuns funs) {
        this.repo = repo;
        this.funs = funs;
    }

    public List<Pet> findAll() {
        return repo.findAll();
    }

    public Optional<Pet> findById(String id) {
        return repo.findById(id);
    }

    public List<Pet> findAllByUserId(String userId) {
        return repo.findAllByUserId(userId);
    }

    public Optional<Pet> findByUserIdAndName(String userId, String name) {
        return repo.findByUserIdAndName(userId, name);
    }

    public Pet createPet(String userId, String name, String type) throws Exception {
        Pet candidate = new Pet(userId, name, type);
        Pet validated = funs.validatePet(candidate, repo);

        return repo.save(validated);
    }

    public Pet createPet(Pet candidate) throws Exception {
        Pet validated = funs.validatePet(candidate, repo);
        return repo.save(validated);
    }
}
