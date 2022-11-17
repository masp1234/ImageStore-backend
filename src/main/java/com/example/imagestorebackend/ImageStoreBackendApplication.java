package com.example.imagestorebackend;

import com.example.imagestorebackend.model.Image;
import com.example.imagestorebackend.model.User;
import com.example.imagestorebackend.repository.ImageRepository;
import com.example.imagestorebackend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ImageStoreBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImageStoreBackendApplication.class, args);
    }
    @Bean
    public CommandLineRunner importData(
            UserRepository userRepository,
            ImageRepository imageRepository


    )
    {
        return (args) -> {

            User user = new User("bobsen", "123123");

            Image image = new Image(
                    "filename",
                    200,
                    350,
                    "et billede",
                    "en billedbeskrivelse",
                    "dsffdfjgfdjgjdf23u823435jejgnjrngjgnjrgnjfdsfdsfsdf");

            userRepository.save(user);
            imageRepository.save(image);



        };}

}
