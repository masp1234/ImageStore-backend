package com.example.imagestorebackend.controller;

import com.example.imagestorebackend.model.Image;
import com.example.imagestorebackend.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/image")
public class ImageController {

    private ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Image>> getAll() {
        return new ResponseEntity<>(imageService.getAllImages(), HttpStatus.OK);
    }
    @PostMapping("/add/{userId}")
    public ResponseEntity<Image> add(@RequestBody Image image,
                                     @PathVariable("userId") Long userId) {
        return new ResponseEntity<>(imageService.save(image, userId), HttpStatus.OK);
    }
}
