package com.bekirarslan.entitylifecycle.controller;

import com.bekirarslan.entitylifecycle.entity.User;
import com.bekirarslan.entitylifecycle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity createUser() {
        User user = new User();
        user.setUserName("Bekir");
        userRepository.save(user);
        return new ResponseEntity<>("User is created", HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
        return new ResponseEntity<>("User is deleted", HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity updateUser(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow();
        user.setFirstName("Beko");
        userRepository.save(user);
        return new ResponseEntity<>("User's name is updated", HttpStatus.OK);
    }


}
