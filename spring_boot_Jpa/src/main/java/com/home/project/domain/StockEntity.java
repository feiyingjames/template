package com.home.project.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@IdClass(StockEntityPK.class)
@Table(name = "stock_entity",
indexes = {@Index(name="week", columnList = ("week")),
            @Index(name="code", columnList = "code"),
            @Index(name="created", columnList = "created")})
public class StockEntity {
    @Id
    private String code;
    private String name;
    @Id
    private Date created;
    private double openPrice;
    private double highPrice;
    private double lowPrice;
    private double closePrice;
    private double totalAmount;
    private double totalMoney;
    private String week;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(double openPrice) {
        this.openPrice = openPrice;
    }

    public double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(double highPrice) {
        this.highPrice = highPrice;
    }

    public double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public double getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(double closePrice) {
        this.closePrice = closePrice;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }
}
