package com.example.imagestorebackend.service;

import com.example.imagestorebackend.model.Image;
import com.example.imagestorebackend.model.User;
import com.example.imagestorebackend.repository.ImageRepository;
import com.example.imagestorebackend.repository.UserRepository;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
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

    public Image save(MultipartFile file, Long userId) {
        User foundUser = userRepository.findById(userId).get();
        Image image = new Image();

        String imageString = null;
        try {
        imageString = new String(file.getBytes());

        }
        catch (IOException e) {
            System.out.println("kunne ikke uploade");
        }

        image.setImage(imageString);
        image.setUser(foundUser);
        image.setCurrentBiteSize(file.getSize());
        return imageRepository.save(image);
    }
}
