package com.Search.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "newsdetails")
public class NewsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serial;
    @Column(columnDefinition = "text")
    private String id;
    @Column(columnDefinition = "text")
    private String title;
    @Column(columnDefinition = "text")
    private String url;
    @Column(columnDefinition = "text")
    private String visitedquery;

}
