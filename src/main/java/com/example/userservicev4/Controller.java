package com.example.userservicev4;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
public class Controller {


    private final UserService userService;

    public Controller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping(value = "/users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }


    @PostMapping("/user")
    public ResponseEntity<String>  createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }



}
