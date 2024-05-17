package com.example.userservicev4;
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
        return Optional.of(userRepository.findById(id).get());
    }


    public List<User> findAll() {
        return userRepository.findAll();
    }

    public ResponseEntity<String> updateUser(Long id, User editedUser) {
        User user = userRepository.findById(id).get();
        if(user != null) {
            user.setUserName(editedUser.getUserName());
            user.setImgUrl(editedUser.getImgUrl());
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

    public ResponseEntity<String> deleteUser(Long id) {
        User user = userRepository.findById(id).get();
        if(user != null) {
            userRepository.delete(user);
            return ResponseEntity
                    .status(201)
                    .build();
        } else {
            return ResponseEntity
                    .status(400)
                    .body("Invalid input");
        }
    }
}
