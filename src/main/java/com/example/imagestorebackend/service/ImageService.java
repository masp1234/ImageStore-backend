package com.example.imagestorebackend.service;

import com.example.imagestorebackend.model.Image;
import com.example.imagestorebackend.repository.ImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    private ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public List<Image> getAllImages() {
        return (List<Image>)imageRepository.findAll();
    }
}
