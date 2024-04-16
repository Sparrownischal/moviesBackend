package com.example.movieapp_backend.services;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.movieapp_backend.models.UserModel;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserModel, String> {
    Optional<UserModel> findByEmail(String email);
}
