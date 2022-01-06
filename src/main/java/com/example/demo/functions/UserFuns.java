package com.example.demo.functions;

import com.example.demo.data.User;
import com.example.demo.data.UserDetails;
import com.example.demo.repsitories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserFuns {
    public User scrubUser(User candidate) {
        return new User(
                candidate.username.trim().toLowerCase(),
                candidate.password.trim().toLowerCase(),
                scrubDetails(candidate.details)
        );
    }

    public User validateUser(User candidate, UserRepository repo) throws Exception {
        User scrubbed = scrubUser(candidate);

        boolean isUsernameTaken = repo.existsByUsername(candidate.username);
        boolean isEmailTaken = repo.existsByDetails_Email(candidate.details.email);

        if (isUsernameTaken) {
            throw new Exception("cannot create because username is taken");
        }

        if (isEmailTaken) {
            throw new Exception("cannot create because email is taken");
        }

        if (scrubbed.username.isBlank()) {
            throw new Exception("cannot create because username is blank");
        }

        if (scrubbed.password.isBlank()) {
            throw new Exception("cannot create because password is blank");
        }

        validateDetails(candidate.details);

        return scrubbed;
    }

    public UserDetails scrubDetails(UserDetails candidate) {
        return new UserDetails(
                candidate.email.trim().toLowerCase(),
                candidate.firstName.trim().toLowerCase(),
                candidate.lastName.trim().toLowerCase()
        );
    }

    public UserDetails validateDetails(UserDetails candidate) throws Exception {
        UserDetails scrubbed = scrubDetails(candidate);

        if (scrubbed.email.isBlank()) {
            throw new Exception("cannot create because email is blank");
        }

        if (scrubbed.firstName.isBlank()) {
            throw new Exception("cannot create because firstname is blank");
        }

        if (scrubbed.lastName.isBlank()) {
            throw new Exception("cannot create because lastname is blank");
        }

        return scrubbed;
    }
}
