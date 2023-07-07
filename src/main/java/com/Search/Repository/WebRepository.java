package com.Search.Repository;

import com.Search.Entity.WebEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WebRepository extends JpaRepository<WebEntity,Integer> {

    List<WebEntity> findByVisitedquery(@Param("query") String query);
}
