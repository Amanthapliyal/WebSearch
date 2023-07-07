package com.Search.ServiceInterface;


import com.Search.Entity.ImageEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ImageService {
    public List<ImageEntity> getImage(String query);
}
