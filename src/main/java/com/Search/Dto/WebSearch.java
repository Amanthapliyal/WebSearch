package com.Search.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebSearch implements Serializable {

    private String id;
    private String title;
    private String url;
    private String description;

}
