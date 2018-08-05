package com.example.lansenboy.kuoutianqi.utils;

import android.text.TextUtils;

import com.example.lansenboy.kuoutianqi.db.City;
import com.example.lansenboy.kuoutianqi.db.County;
import com.example.lansenboy.kuoutianqi.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {
    /**
     * 解析和处理服务器返回的省级数据
     */
    public static boolean handleProvinceResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allProvince = new JSONArray(response);
                for (int i = 0; i < allProvince.length(); i++) {
                    JSONObject provinceObject = allProvince.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handleCityResponse(String respnse) {
        try {
            JSONArray allCity = new JSONArray(respnse);
            for (int i = 0; i < allCity.length(); i++) {
                JSONObject cityObject = allCity.getJSONObject(i);
                City city = new City();
                city.setCityName(cityObject.getString("name"));
                city.setCityCode(cityObject.getInt("id"));
                city.save();
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * 解析和处理服务器返回的县级数据
     */
    public static boolean handleCountyResponse(String respnse, int cityId) {
        try {
            JSONArray allCounty = new JSONArray(respnse);
            for (int i = 0; i < allCounty.length(); i++) {
                JSONObject countyObject = allCounty.getJSONObject(i);
                County county = new County();

                county.setCountyName(countyObject.getString("name"));
                county.setCityId(cityId);
                county.setWeatherId(countyObject.getString("weather_id"));
                county.save();
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

}
