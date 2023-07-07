package com.Search.Converter;

import com.Search.Dto.Dto;
import com.Search.Dto.ImageSearch;
import com.Search.Dto.NewsSearch;
import com.Search.Dto.WebSearch;
import com.Search.Entity.ImageEntity;
import com.Search.Entity.NewsEntity;
import com.Search.Entity.WebEntity;
import com.Search.Fields.ImageFieldValues;
import com.Search.Fields.NewsFieldsValue;
import com.Search.Fields.WebFieldsValue;
import com.Search.Repository.ImageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Converter {

    @Autowired
    ModelMapper modelMapper;

    public ImageEntity fieldsToEntity(ImageFieldValues imageFieldValues,String query) {
        ImageEntity imageEntity = this.modelMapper.map(imageFieldValues,ImageEntity.class);
        imageEntity.setVisitedquery(query);
        return imageEntity;
    }

    public NewsEntity newsFieldsToEntity(NewsFieldsValue newsFieldsValue, String query){
        NewsEntity newsEntity = this.modelMapper.map(newsFieldsValue,NewsEntity.class);
        newsEntity.setVisitedquery(query);
        return newsEntity;
    }

    public WebEntity webFieldsToEntity(WebFieldsValue webFieldsValue , String query){
        WebEntity webEntity = this.modelMapper.map(webFieldsValue,WebEntity.class);
        webEntity.setVisitedquery(query);
        return webEntity;

    }

    public ImageSearch dtoToImageEntity(ImageEntity imageEntity){
        ImageSearch imageSearch = this.modelMapper.map(imageEntity,ImageSearch.class);
        return imageSearch;
    }

    public List<ImageSearch> dtoToImageEntity(List<ImageEntity> imageEntity){
        List<ImageSearch> imageSearch = new ArrayList<>();
        imageSearch = imageEntity.stream().map(x->dtoToImageEntity(x)).collect(Collectors.toList());
        return imageSearch;
    }


    public NewsSearch dtoToNewsEntity(NewsEntity newsEntity){
        NewsSearch newsSearch = this.modelMapper.map(newsEntity,NewsSearch.class);
        return newsSearch;
    }

    public List<NewsSearch> dtoToNewsEntity(List<NewsEntity> newsEntity){
        List<NewsSearch> newsSearch = new ArrayList<>();
        newsSearch = newsEntity.stream().map(x->dtoToNewsEntity(x)).collect(Collectors.toList());
        return newsSearch;
    }

    public WebSearch dtoToWebEntity(WebEntity entity){
        WebSearch webSearch = this.modelMapper.map(entity,WebSearch.class);
        return webSearch;
    }

    public List<WebSearch> dtoToWebEntity(List<WebEntity> webEntity){
        List<WebSearch> webSearch = new ArrayList<>();
        webSearch = webEntity.stream().map(x->dtoToWebEntity(x)).collect(Collectors.toList());
        return webSearch;
    }


}
