package com.Search.ServiceImplements;

import com.Search.Adapter.WebAdapter;
import com.Search.Converter.Converter;
import com.Search.Entity.ImageEntity;
import com.Search.Entity.WebEntity;
import com.Search.Fields.ImageFields;
import com.Search.Fields.WebFields;
import com.Search.Repository.WebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WebServiceImplementation {
    @Autowired
    WebAdapter webAdapter;
    @Autowired
    WebRepository webRepository;
    @Autowired
    Converter converter;

    public List<WebEntity> getWeb(String query){
        WebFields webFields = webAdapter.getWebAdapter(query);
        List<WebEntity> webEntities = new ArrayList<>();
        webEntities =  webFields.getValue().stream().map( x -> converter.webFieldsToEntity(x,query)).collect(Collectors.toList());
        webRepository.saveAll(webEntities);
        return webEntities;
    }
}
