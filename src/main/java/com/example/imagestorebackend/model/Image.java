package com.example.imagestorebackend.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private

    @ManyToOne("images")
    private User user;

    private String filename;

    private int originalByteSize;

    private int currentBiteSize;

    private String title;

    private String description;
}
