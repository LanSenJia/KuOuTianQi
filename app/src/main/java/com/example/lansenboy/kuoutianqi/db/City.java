package com.example.lansenboy.kuoutianqi.db;

import org.litepal.crud.DataSupport;

/**
 *
 * Created by lansenboy on 2018/6/8.
 */

public class City extends DataSupport {

    private int id;
    // 市的名字
    private String cityName;
    // 市的代号
    private int cityCode;
    // 当前市 对应的省
    private int provinceId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }
}
