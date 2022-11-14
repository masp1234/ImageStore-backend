package com.example.imagestorebackend.repository;

import com.example.imagestorebackend.model.UserDude;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserDude,Long> {
}
