package com.example.lansenboy.kuoutianqi.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lansenboy.kuoutianqi.R;
import com.example.lansenboy.kuoutianqi.db.City;
import com.example.lansenboy.kuoutianqi.db.County;
import com.example.lansenboy.kuoutianqi.db.Province;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class ChooseAreaFragment extends Fragment {
    public static final int LEVEL_PROVINCE = 0;
    public static final int LEVEL_CITY = 1;
    public static final int LEVEL_COUNTY = 2;

    /**
     * 省列表
     */
    private List<Province> provinceList;

    /**
     * 市列表
     */
    private List<City> cityList;

    /**
     * 县列表
     */
    private List<County> countyList;

    /**
     * 选中的省份
     */
    private Province selectProvince;

    /**
     * 选中的城市
     */
    private City selectCity;
    /**
     * 当前选中的级别
     */
    private int currentLevel;
    private TextView titleText;
    private Button icBack;
    private ListView listview;
    private List<String> dataList = new ArrayList();
    private ArrayAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.choose_area, container, false);
        titleText = (TextView) view.findViewById(R.id.title_text);
        icBack = (Button) view.findViewById(R.id.ic_back);
        listview = (ListView) view.findViewById(R.id.listview);
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, dataList);
        listview.setAdapter(adapter);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (currentLevel == LEVEL_PROVINCE) {
                    selectProvince = provinceList.get(i);
                    queryCities();
                } else if (currentLevel == LEVEL_CITY) {
                    selectCity = cityList.get(i);
                    queryCounties();
                }
            }
        });

        icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentLevel == LEVEL_COUNTY) {

                } else if (currentLevel == LEVEL_CITY) {

                }
            }
        });
        queryProvinces();
    }

    /**
     * 查询全国的省份，优先从数据库中查询，如果没有查询到再去服务器中查询
     */
    private void queryProvinces() {
        titleText.setText("中国");
        icBack.setVisibility(View.GONE);
        provinceList = DataSupport.findAll(Province.class);
        if (provinceList.size() > 0) {
            dataList.clear();
            for (Province province : provinceList) {
                dataList.add(province.getProvinceName());
            }
            adapter.notifyDataSetChanged();
            listview.setSelection(0);
            currentLevel = LEVEL_PROVINCE;
        } else {
            String address = "http://guolin.tech/api/china";
//            queryFromServer(address, "province");
        }

    }

    /**
     * 查询省内所有市，优先从数据库中查询，如果没有查询到再去服务器中查询
     */
    private void queryCities() {
        titleText.setText(selectProvince.getProvinceName());
        icBack.setVisibility(View.VISIBLE);
        cityList = DataSupport.where("provinced = ?", String.valueOf(selectProvince.getId())).find(City.class);
    }

    private void queryCounties() {
    }

    private void queryFromServer() {
    }
}
