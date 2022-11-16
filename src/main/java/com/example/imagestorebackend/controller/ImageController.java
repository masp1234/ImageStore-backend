package com.example.imagestorebackend.controller;

import com.example.imagestorebackend.model.Image;
import com.example.imagestorebackend.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @PostMapping(value = "/add/{userId}")
    public ResponseEntity<Image> add(@RequestParam("image") MultipartFile file,
                                     @PathVariable("userId") Long userId) {
        return new ResponseEntity<>(imageService.save(file, userId), HttpStatus.OK);
    }
}
