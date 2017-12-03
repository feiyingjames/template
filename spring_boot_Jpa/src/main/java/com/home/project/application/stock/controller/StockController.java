package com.home.project.application.stock.controller;

import com.home.project.application.stock.service.StockService;
import com.home.project.domain.StockEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
//@RequestMapping("/api")
public class StockController {

    @Autowired
    private StockService stockService;

    @RequestMapping(path="/stocks", method = RequestMethod.GET)
    @ResponseBody
    public List<StockEntity> getAllSotck() {
        return stockService.findAll();
    }
}
