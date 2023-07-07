package com.Search.Controller;

import com.Search.Converter.Converter;
import com.Search.Dto.Dto;
import com.Search.Entity.ImageEntity;
import com.Search.Entity.NewsEntity;
import com.Search.Entity.WebEntity;
import com.Search.ServiceImplements.AllServiceImplemention;
import com.Search.ServiceImplements.ImageServiceImplements;
import com.Search.ServiceImplements.NewsServiceImplementation;
import com.Search.ServiceImplements.WebServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController
public class Controller implements Serializable {

    @Autowired
    private ImageServiceImplements imageServiceImplements;
    @Autowired
    private NewsServiceImplementation newsServiceImplementation;
    @Autowired
    private WebServiceImplementation webServiceImplementation;
    @Autowired
    Converter converter;
    @Autowired
    private AllServiceImplemention allServiceImplemention;

    @GetMapping("/{query}")
    public Dto getQueryController(@PathVariable String query)
    {
        Dto dto = allServiceImplemention.allItems(query);
        return dto;
    }
    @GetMapping("Image/{query}")
    public List<ImageEntity> getImageController(@PathVariable String query)
    {
        List<ImageEntity> imageEntity= imageServiceImplements.getImage(query);
        return imageEntity;
    }
    @GetMapping("News/{query}")
    public List<NewsEntity> getNewsController(@PathVariable String query)
    {
        List<NewsEntity> newsEntity = newsServiceImplementation.getNews(query);
        return newsEntity;
    }

    @GetMapping("Web/{query}")
    public List<WebEntity> getWebController(@PathVariable String query)
    {
        List<WebEntity> webEntity = webServiceImplementation.getWeb(query);
        return webEntity;
    }
}
