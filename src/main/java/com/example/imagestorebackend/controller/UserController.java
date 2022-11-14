package com.example.imagestorebackend.controller;


import com.example.imagestorebackend.model.User;
import com.example.imagestorebackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/{username}/{password}")
    public ResponseEntity<User> validateUser(@PathVariable("username") String username,
                                             @PathVariable("password") String password) {
        return new ResponseEntity<>(userService.validateUser(username, password), HttpStatus.OK);
    }

}
