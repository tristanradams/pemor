package com.example.demo.config;


import com.example.demo.data.Pet;
import com.example.demo.data.User;
import com.example.demo.data.UserDetails;
import com.example.demo.repsitories.PetRepository;
import com.example.demo.repsitories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DatabaseSeeder {
    UserRepository userRepository;
    PetRepository petRepository;

    @Autowired
    public DatabaseSeeder(UserRepository userRepository, PetRepository petRepository) {
        this.userRepository = userRepository;
        this.petRepository = petRepository;
    }

    User[] users = new User[]{
            new User(
                    "betty_white",
                    "password",
                    new UserDetails(
                            "betty@white.com",
                            "betty",
                            "white"
                    )
            ),
            new User(
                    "john_stamos",
                    "password",
                    new UserDetails(
                            "john@stamos.com",
                            "john",
                            "stamos"
                    )
            ),
            new User(
                    "larry_king",
                    "password",
                    new UserDetails(
                            "larry@king.com",
                            "larry",
                            "king"
                    )
            ),
            new User(
                    "sandra_bullock",
                    "password",
                    new UserDetails(
                            "sandra@bullock.com",
                            "sandra",
                            "bullock"
                    )
            )
    };

    Pet[][] pets = new Pet[][]{
            new Pet[]{
                    new Pet(users[0].id, "poppy", "dog"),
                    new Pet(users[0].id, "smitty", "cat"),
                    new Pet(users[0].id, "lucy", "cat"),
            },
            new Pet[]{
                    new Pet(users[1].id, "percy", "cat"),
                    new Pet(users[1].id, "tank", "cat"),
            },
            new Pet[]{
                    new Pet(users[2].id, "rex", "dog"),
                    new Pet(users[2].id, "bruiser", "dog"),
            },
            new Pet[]{
                    new Pet(users[3].id, "tilly", "dog"),
            }
    };

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReadyEvent() {
        seedDatabase();
    }

    public void seedDatabase() {
        userRepository.deleteAll();
        petRepository.deleteAll();

        userRepository.saveAll(Arrays.asList(users));

        for (Pet[] array : pets) {
            petRepository.saveAll(Arrays.asList(array));
        }
    }
}
