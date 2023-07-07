package com.Search.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "imagedetails")
public class ImageEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int recordid;

    @Column(columnDefinition = "text")
    private String url;
    private long height;
    private long width;
    @Column(columnDefinition = "text")
    private String thumbnail;
    @Column(columnDefinition = "text")
    private String visitedquery;
}
