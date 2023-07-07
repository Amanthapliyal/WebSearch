package com.Search.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dto implements Serializable {

    private List<ImageSearch> imageSearch;
    private List<NewsSearch> newsSearch;
    private List<WebSearch> webSearch;

}
