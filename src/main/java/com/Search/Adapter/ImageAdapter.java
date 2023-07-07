package com.Search.Adapter;

import com.Search.Fields.ImageFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Component
public class ImageAdapter {

    @Autowired
    RestTemplate restTemplate;

    String rapidApiKey = "X-RapidAPI-Key";
    String key = "fddcfb5e08msh6eb2fa83a15fd8dp1fc008jsn1066abed18d1";
    String rapidApiHost = "X-RapidAPI-Host";
    String hostKey = "contextualwebsearch-websearch-v1.p.rapidapi.com";

    public ImageFields getImageAdapter(String query){
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("https://contextualwebsearch-websearch-v1.p.rapidapi.com/api/Search/ImageSearchAPI")
                .queryParam("q",query)
                .queryParam("pageNumber","1")
                .queryParam("pageSize","10")
                .queryParam("autoCorrect","true");

        String url = builder.toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.set(rapidApiKey,key);
        headers.set(rapidApiHost,hostKey);



        ParameterizedTypeReference<List<ImageFields>> responseType = new ParameterizedTypeReference<List<ImageFields>>() {};

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        ImageFields responseEntity = restTemplate.exchange(url, HttpMethod.GET,httpEntity, ImageFields.class).getBody();
        return responseEntity;
    }
}