package com.example.movieapp_backend.services;

import com.example.movieapp_backend.models.UserModel; // Import your UserModel class
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; // Add PasswordEncoder

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) { // Inject PasswordEncoder
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder; // Initialize PasswordEncoder
    }

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }


    public Optional<UserModel> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public UserModel getUserById(String id) {
        Optional<UserModel> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    public UserModel addUser(UserModel user) {
        Optional<UserModel> existingUser = findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("User already exists with email: " + user.getEmail());
        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public boolean authenticateUser(String email, String password) {
        Optional<UserModel> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent()) {
            UserModel user = userOpt.get();
            return passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }
}
