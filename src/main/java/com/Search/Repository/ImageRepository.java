package com.Search.Repository;

import com.Search.Entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity,Integer> {

    List<ImageEntity> findByVisitedquery(@Param("query") String query);
}
