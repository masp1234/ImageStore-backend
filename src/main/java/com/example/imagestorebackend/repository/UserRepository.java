package com.example.imagestorebackend.repository;

import com.example.imagestorebackend.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {


    User findByUsername(String username);
}
