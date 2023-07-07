package com.Search.ServiceImplements;

import com.Search.Adapter.ImageAdapter;
import com.Search.Converter.Converter;
import com.Search.Dto.Dto;
import com.Search.Entity.ImageEntity;
import com.Search.Fields.ImageFields;
import com.Search.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RestControllerAdvice
public class ImageServiceImplements  {

    @Autowired
    ImageAdapter imageAdapter;

    @Autowired
    Converter converter;
    @Autowired
    ImageRepository imageRepository;

    public List<ImageEntity> getImage(String query)  {
        ImageFields imageFields = imageAdapter.getImageAdapter(query);
        List<ImageEntity> imageEntities = new ArrayList<>();
        imageEntities =  imageFields.getValue().stream().map( x -> converter.fieldsToEntity(x,query)).collect(Collectors.toList());
        imageRepository.saveAll(imageEntities);


        return imageEntities;
    }

}
