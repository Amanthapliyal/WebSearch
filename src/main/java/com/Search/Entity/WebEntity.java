package com.Search.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "webdetails")
@Entity
public class WebEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serialno;
    @Column(columnDefinition = "text")
    private String id;
    @Column(columnDefinition = "text")
    private String title;
    @Column(columnDefinition = "text")
    private String url;
    @Column(columnDefinition = "text")
    private String description;
    @Column(columnDefinition = "text")
    private String visitedquery;

}
