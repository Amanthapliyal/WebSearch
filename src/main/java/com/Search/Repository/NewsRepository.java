package com.Search.Repository;

import com.Search.Entity.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<NewsEntity,Integer> {

    List<NewsEntity> findByVisitedquery(@Param("query") String query);
}
