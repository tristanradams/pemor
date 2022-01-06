package com.example.demo.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.UUID;

@CompoundIndex(
        def = "{'details.email': 1}",
        name = "email",
        unique = true
)
public class User {
    @Id
    public String id = UUID.randomUUID().toString();

    @Indexed(unique = true)
    public String username;
    public String password;
    public UserDetails details;


    public User(String username, String password, UserDetails details) {
        this.username = username;
        this.password = password;
        this.details = details;
    }

    @Override
    public String toString() {
        return String.format("User[id=%s, username='%s', password='%s', '%s']", id, username, password, details.toString());
    }
}
