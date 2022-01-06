package com.example.demo.controllers;

import com.example.demo.data.Pet;
import com.example.demo.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/pets")
@RestController
public class PetController {
    public PetService service;

    @Autowired
    public PetController(PetService service) {
        this.service = service;
    }

    @ExceptionHandler
    public String handle(Exception e) {
        return e.getMessage();
    }

    @GetMapping
    public List<Pet> getPets() {
        return service.findAll();
    }

    @PostMapping
    public Pet createUser(@RequestBody Pet candidate) throws Exception {
        return service.createPet(candidate);
    }

    @GetMapping("/find")
    public List<Pet> findPetsByUserId(@RequestParam String id) {
        return service.findAllByUserId(id);
    }
}
