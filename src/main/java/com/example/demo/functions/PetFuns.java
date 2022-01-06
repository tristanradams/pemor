package com.example.demo.functions;

import com.example.demo.data.Pet;
import com.example.demo.repsitories.PetRepository;
import org.springframework.stereotype.Component;

@Component
public class PetFuns {
    public Pet scrubPet(Pet candidate) {
        return new Pet(
                candidate.userId.trim().toLowerCase(),
                candidate.name.trim().toLowerCase(),
                candidate.type.trim().toLowerCase()
        );
    }

    public Pet validatePet(Pet candidate, PetRepository repo) throws Exception {
        Pet scrubbed = scrubPet(candidate);
        boolean doesPetExist = repo.existsByUserIdAndName(candidate.userId, candidate.name);

        if (doesPetExist) {
            throw new Exception("cannot create because pet already exists");
        }

        if (scrubbed.name.isBlank()) {
            throw new Exception("cannot create because username is blank");
        }

        if (scrubbed.type.isBlank()) {
            throw new Exception("cannot create because password is blank");
        }

        return scrubbed;
    }
}
