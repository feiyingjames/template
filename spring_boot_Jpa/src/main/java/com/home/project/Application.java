package com.home.project;

import com.home.project.application.stock.service.StockImportService;
import com.home.project.domain.StockEntity;
import com.home.project.jpa.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

import java.io.InputStream;

import static java.lang.System.exit;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    DataSource dataSource;

    @Autowired
    StockRepository stockRepository;

    @Autowired
    StockImportService stockImportService;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("DATASOURCE = " + dataSource);

        System.out.println("\n0. import data");

        long start = System.currentTimeMillis();
        stockImportService.importAll();

        System.out.println("it takes "+ (System.currentTimeMillis() - start));
//        System.out.println("\n1.findAll()...");
//        for (StockEntity customer : stockRepository.findAll()) {
//            System.out.println(customer);
//        }

        System.out.println("Done!");

        exit(0);
    }
}
