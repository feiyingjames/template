package com.home.project.application.stock.service.impl;

import com.home.project.application.stock.service.StockImportService;
import com.home.project.application.stock.service.StockService;
import com.home.project.domain.StockEntity;
import com.home.project.utils.DateUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

@Service
public class StockImportServiceImpl implements StockImportService {
    @Autowired
    private StockService stockService;

    @Value("${stock.data.folder}")
    private String defaultFolder;

    @Override
    public void importStock(String folder) {
        File dir = new File(folder);

        List<File> files = (List<File>) FileUtils.listFiles(dir, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);

        ForkJoinPool customThreadPool = new ForkJoinPool(50);
        try {
            customThreadPool.submit(() -> files.parallelStream().forEach(file -> parseFile(file))).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void importAll() {
        importStock(defaultFolder);
    }

    private void parseFile(File file) {
        try {
            long start = System.currentTimeMillis();

            List<String> lines = FileUtils.readLines(file, "UTF-8");
            String name = file.getName();
            System.out.println("it take to read "  + name + "," + (System.currentTimeMillis() - start));
            start = System.currentTimeMillis();
            String code = name.substring(name.indexOf("#") + 1, name.indexOf("."));
            List<StockEntity> entities = new ArrayList<>();
            lines.stream().forEach(line -> {
                String[] values = line.split("\t");
                if(values.length == 7) {
                    entities.add(parseRecord(values, code));
                }
            });
            if(entities.size() > 0) {
                stockService.save(entities);
            }

            System.out.println("it take to write db "  + name + "," + (System.currentTimeMillis() - start));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private StockEntity parseRecord(String[] values, String code) {
        StockEntity entity = new StockEntity();
        entity.setName(code);
        entity.setCode(code);
        try {
            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd", Locale.CHINA);
            Date created = simpleDateFormat.parse(values[0]);

            entity.setWeek(DateUtil.getWeek(created));
            entity.setCreated(created);
        } catch (Exception e) {
            System.out.println("Code is " + code + ", values is " + Arrays.toString(values));
            e.printStackTrace();
        }
        entity.setOpenPrice(Double.valueOf(values[1]));
        entity.setHighPrice(Double.valueOf(values[2]));
        entity.setLowPrice(Double.valueOf(values[3]));
        entity.setClosePrice(Double.valueOf(values[4]));
        entity.setTotalAmount(Double.valueOf(values[5]));
        entity.setTotalMoney(Double.valueOf(values[6]));
        return entity;
//        stockService.save(entity);

    }
}
