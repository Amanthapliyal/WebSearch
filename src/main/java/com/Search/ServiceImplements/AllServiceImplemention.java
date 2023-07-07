package com.Search.ServiceImplements;

import com.Search.Adapter.*;
import com.Search.Converter.Converter;
import com.Search.Dto.Dto;
import com.Search.Entity.*;
import com.Search.Fields.*;
import com.Search.Repository.*;
import com.Search.ServiceInterface.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@CacheConfig(cacheNames = {"ServiceInterface"})
public class AllServiceImplemention implements ServiceInterface {

    @Autowired
    ImageAdapter imageAdapter;
    @Autowired
    Converter converter;
    @Autowired
    ImageRepository imageRepository;
    @Autowired
    NewsAdapter newsAdapter;
    @Autowired
    NewsRepository newsRepository;
    @Autowired
    WebAdapter webAdapter;
    @Autowired
    WebRepository webRepository;
    @Autowired
    QueryRepository queryRepository;

    @Cacheable()
    public Dto allItems(String query) {

        Optional<QueryEntity> queryResult = Optional.ofNullable(queryRepository.findBySearchedqry(query));
        Dto dto = new Dto();
        if (queryResult.isEmpty()) {

            ImageFields imageFields = imageAdapter.getImageAdapter(query);
            List<ImageEntity> imageEntities = new ArrayList<>();
            imageEntities = imageFields.getValue().stream().map(x -> converter.fieldsToEntity(x, query)).collect(Collectors.toList());
            imageRepository.saveAll(imageEntities);

            NewsFields newsFields = newsAdapter.getNewsAdapter(query);
            List<NewsEntity> newsEntities = new ArrayList<>();
            newsEntities = newsFields.getValue().stream().map(x -> converter.newsFieldsToEntity(x, query)).collect(Collectors.toList());
            newsRepository.saveAll(newsEntities);

            WebFields webFields = webAdapter.getWebAdapter(query);
            List<WebEntity> webEntities = new ArrayList<>();
            webEntities = webFields.getValue().stream().map(x -> converter.webFieldsToEntity(x, query)).collect(Collectors.toList());
            webRepository.saveAll(webEntities);

            dto.setImageSearch(converter.dtoToImageEntity(imageEntities));
            dto.setNewsSearch(converter.dtoToNewsEntity(newsEntities));
            dto.setWebSearch(converter.dtoToWebEntity(webEntities));

            QueryEntity queryEntity = new QueryEntity();
            queryEntity.setSearchedqry(query);
            queryRepository.save(queryEntity);
        }
        else
        {
            System.out.println("Query Already Searched");
            List<ImageEntity> imageEntities = imageRepository.findByVisitedquery(query);
            List<NewsEntity> newsEntities = newsRepository.findByVisitedquery(query);
            List<WebEntity> webEntities = webRepository.findByVisitedquery(query);
            dto.setImageSearch(converter.dtoToImageEntity(imageEntities));
            dto.setNewsSearch(converter.dtoToNewsEntity(newsEntities));
            dto.setWebSearch(converter.dtoToWebEntity(webEntities));
        }
    return dto;
    }
}
