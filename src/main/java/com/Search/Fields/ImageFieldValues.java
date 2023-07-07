package com.Search.Fields;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageFieldValues {
    private String url;
    private long height;
    private long width;
    private String thumbnail;

}
