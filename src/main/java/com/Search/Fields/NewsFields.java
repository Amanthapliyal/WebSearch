package com.Search.Fields;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewsFields {
    private String _type;
    private String didUMean;
    private long totalCount;
    private List<NewsFieldsValue> value;

}
