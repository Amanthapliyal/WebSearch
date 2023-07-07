package com.Search.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ImageSearch implements Serializable {

    private String url;
    private long height;
    private long width;

    private String thumbnail;


}
