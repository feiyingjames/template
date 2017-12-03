package com.home.project.domain;

import java.io.Serializable;
import java.util.Date;

public class StockEntityPK implements Serializable {
    private String code;
    private Date created;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
