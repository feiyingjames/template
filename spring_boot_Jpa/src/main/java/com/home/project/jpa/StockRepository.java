package com.home.project.jpa;

import com.home.project.domain.StockEntity;
import com.home.project.domain.StockEntityPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface StockRepository extends CrudRepository<StockEntity, StockEntityPK> {
//    List<StockEntity> findByWeek();

//    @Query("select c from StockEntity c where c.week = :week")
//    Stream<StockEntity> findByEmailReturnStream(@Param("week") String week);
}
