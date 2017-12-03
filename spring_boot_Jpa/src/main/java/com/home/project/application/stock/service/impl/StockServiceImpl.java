package com.home.project.application.stock.service.impl;

import com.home.project.application.stock.service.StockService;
import com.home.project.domain.StockEntity;
import com.home.project.jpa.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<StockEntity> findAll() {
        return (List<StockEntity>) stockRepository.findAll();
    }

    @Override
    public void save(StockEntity entity) {
        stockRepository.save(entity);
    }

    public void save(List<StockEntity> entities) {
        stockRepository.save(entities);
    }
}
