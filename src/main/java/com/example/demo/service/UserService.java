package com.example.demo.service;

import com.example.demo.data.User;
import com.example.demo.data.UserDetails;
import com.example.demo.functions.UserFuns;
import com.example.demo.repsitories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    UserRepository repo;
    UserFuns funs;

    @Autowired
    public UserService(UserRepository repo, UserFuns funs) {
        this.repo = repo;
        this.funs = funs;
    }

    public List<User> findAll() {
        return repo.findAll();
    }

    public Optional<User> findById(String id) {
        return repo.findById(id);
    }

    public Optional<User> findByUsername(String username) {
        return repo.findByUsername(username);
    }

    public Optional<User> findByEmail(String email) {
        return repo.findByDetails_Email(email);
    }

    public User createUser(String username, String password, String email, String firstname, String lastName) throws Exception {
        UserDetails candidateDetails = new UserDetails(email, firstname, lastName);
        User candidate = new User(username, password, candidateDetails);

        User validated = funs.validateUser(candidate, repo);

        return repo.save(validated);
    }

    public User createUser(User candidate) throws Exception {
        User validated = funs.validateUser(candidate, repo);

        return repo.save(validated);
    }
}
