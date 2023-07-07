package com.Search.Adapter;


import com.Search.Fields.NewsFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Component
public class NewsAdapter {

    @Autowired
    RestTemplate restTemplate;
    String rapidApiKey = "X-RapidAPI-Key";
    String key = "fddcfb5e08msh6eb2fa83a15fd8dp1fc008jsn1066abed18d1";
    String rapidApiHost = "X-RapidAPI-Host";
    String hostKey = "contextualwebsearch-websearch-v1.p.rapidapi.com";

    public NewsFields getNewsAdapter(String query){
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("https://contextualwebsearch-websearch-v1.p.rapidapi.com/api/search/NewsSearchAPI")
                .queryParam("q",query)
                .queryParam("pageNumber","1")
                .queryParam("pageSize","10")
                .queryParam("autoCorrect","true");

        String url = builder.toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.set(rapidApiKey,key);
        headers.set(rapidApiHost,hostKey);


        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        NewsFields responseEntity = restTemplate.exchange(url, HttpMethod.GET,httpEntity, NewsFields.class).getBody();
        return responseEntity;
    }
}
