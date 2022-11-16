package com.example.imagestorebackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date timeStamp;

    @ManyToOne
    @JsonBackReference
    private User user;

    private String filename;

    private Long originalByteSize;

    private Long currentBiteSize;

    private String title;

    private String description;

    @Lob
    private String image;

    public Image(User user, String filename, Long originalByteSize, Long currentBiteSize, String title, String description, String image) {
        this.timeStamp = new Date();
        this.user = user;
        this.filename = filename;
        this.originalByteSize = originalByteSize;
        this.currentBiteSize = currentBiteSize;
        this.title = title;
        this.description = description;
        this.image = image;
    }
}
