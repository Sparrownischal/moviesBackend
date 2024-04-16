package com.example.movieapp_backend.controllers;

import com.example.movieapp_backend.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.example.movieapp_backend.models.UserModel;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserModel getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserModel userModel) {
        try {
            UserModel newUser = userService.addUser(userModel);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (EmailAlreadyExistsExcept e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT); // HttpStatus.CONFLICT indicates a duplicate entry
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserModel> getUserByEmail(@PathVariable String email) {
        Optional<UserModel> user = userService.findByEmail(email);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

//    @PostMapping("/login")
//    public ResponseEntity<?> authenticateUser(@RequestBody UserLoginDTO userLoginDTO) {
//        boolean isAuthenticated = userService.authenticateUser(userLoginDTO.getEmail(), userLoginDTO.getPassword());
//        if (isAuthenticated) {
//            return new ResponseEntity<>("Authentication successful", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Authentication failed", HttpStatus.UNAUTHORIZED);
//        }
//    }

}
