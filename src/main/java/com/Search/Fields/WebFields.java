package com.Search.Fields;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebFields{

    private String _type;
    private String didUMean;
    private long totalCount;
    private List<String> relatedSearch;
    private List<WebFieldsValue> value;

}
