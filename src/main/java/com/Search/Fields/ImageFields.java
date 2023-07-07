package com.Search.Fields;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageFields {

    private String _type ;
    private long totalCount;
    private List<ImageFieldValues> value;

}

