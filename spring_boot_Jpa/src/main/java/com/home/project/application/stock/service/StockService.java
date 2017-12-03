package com.home.project.application.stock.service;

import com.home.project.domain.StockEntity;

import java.util.List;

public interface StockService {
    List<StockEntity> findAll();
    void save(StockEntity entity);
    void save(List<StockEntity> entities);
}
