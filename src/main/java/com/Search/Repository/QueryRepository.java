package com.Search.Repository;

import com.Search.Entity.QueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueryRepository extends JpaRepository<QueryEntity,Integer> {

//    @Query("SELECT a FROM searchedquery a WHERE a.searchedqry Like %:query%")
    QueryEntity findBySearchedqry(@Param("query") String query);

}
