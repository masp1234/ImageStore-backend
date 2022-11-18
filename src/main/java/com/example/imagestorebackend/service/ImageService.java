package com.example.imagestorebackend.service;

import com.example.imagestorebackend.model.Image;
import com.example.imagestorebackend.model.User;
import com.example.imagestorebackend.repository.ImageRepository;
import com.example.imagestorebackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ImageService {

    private ImageRepository imageRepository;
    private UserRepository userRepository;

    public ImageService(ImageRepository imageRepository, UserRepository userRepository) {
        this.imageRepository = imageRepository;
        this.userRepository = userRepository;
    }

    public List<Image> getAllImages() {
        return (List<Image>)imageRepository.findAll();
    }

    public Image save(Image image, Long userId) {
        User foundUser = userRepository.findById(userId).get();
        image.setTimeStamp(new Date());
        image.setUser(foundUser);
        return imageRepository.save(image);
    }
}
