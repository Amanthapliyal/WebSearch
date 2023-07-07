package com.Search.ServiceImplements;

import com.Search.Adapter.NewsAdapter;
import com.Search.Converter.Converter;
import com.Search.Entity.NewsEntity;
import com.Search.Fields.NewsFields;
import com.Search.Fields.NewsFieldsValue;
import com.Search.Repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class NewsServiceImplementation {

    @Autowired
    NewsAdapter newsAdapter;
    @Autowired
    Converter converter;
    @Autowired
    NewsRepository newsRepository;
    public List<NewsEntity> getNews(String query){
        NewsFields newsFields = newsAdapter.getNewsAdapter(query);
        List<NewsEntity> newsEntities = new ArrayList<>();
        newsEntities = newsFields.getValue().stream().map(x->converter.newsFieldsToEntity(x,query)).collect(Collectors.toList());
        newsRepository.saveAll(newsEntities);

        return newsEntities;
    }

}
