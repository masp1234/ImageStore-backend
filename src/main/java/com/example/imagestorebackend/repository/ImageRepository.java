package com.example.imagestorebackend.repository;

import com.example.imagestorebackend.model.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image,Long> {
}
