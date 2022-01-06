package com.example.demo.data;

import org.springframework.data.annotation.Id;

import java.util.UUID;

public class Pet {
    @Id
    public String id = UUID.randomUUID().toString();
    public String userId;
    public String name;
    public String type;

    public Pet(String userId, String name, String type) {
        this.userId = userId;
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("Pet[id='%s', userId='%s', name='%s', type='%s']", id, userId, name, type);
    }
}
