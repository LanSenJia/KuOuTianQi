package com.example.lansenboy.kuoutianqi.db;

/**
 * Created by Administrator on 2018/8/2.
 */

public class County {
    private int id;
    //记录县的名字
    private String countyName;
    //记录县所对应的天气 ID
    private String weatherId;
    //记录县所对应的市的名字
    private int cityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(String weatherId) {
        this.weatherId = weatherId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

}
