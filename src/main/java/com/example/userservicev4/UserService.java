package com.example.userservicev4;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<String> createUser(User user) {
        if(user != null) {
            userRepository.save(user);
            return ResponseEntity
                    .status(201)
                    .build();
        } else {
            return ResponseEntity
                    .status(400)
                    .body("Invalid input");
        }
    }

    public Optional<User> getUser(Long id) {
        return Optional.of(userRepository.findByUserId(id.toString()));
    }


    public List<User> findAll() {
        return userRepository.findAll();
    }
}
