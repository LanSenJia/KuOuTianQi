package com.example.lansenboy.kuoutianqi.db;

import org.litepal.crud.DataSupport;

/**
 * Created by lansenboy on 2018/6/8.
 */

//LitePal 每个实体类 都需要继承 DataSupport

public class Province extends DataSupport {

    private int id;
    //记录省的名字
    private String provinceName;
    //记录省的代号
    private int provinceCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }
}
