package com.la.playground3.view.apps.demo;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.google.android.material.appbar.MaterialToolbar;
import com.la.playground3.R;
import com.la.playground3.common.CustomActivity;
import com.la.playground3.entity.AdapterDemoBean;
import com.la.playground3.view.apps.demo.citypicker.CityPickerCustomDataActivity;
import com.la.playground3.view.apps.demo.citypicker.CityPickerJDActivity;
import com.la.playground3.view.apps.demo.citypicker.CityPickerMainActivity;
import com.la.playground3.view.apps.demo.citypicker.CityPickerSingleListActivity;
import com.la.playground3.view.apps.demo.citypicker.CityPickerThreeListActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CityPickerActivity extends CustomActivity {


    private MaterialToolbar demoCityPickerMtb;
    private ListView demoCityPickerLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_picker);
        initView();
        initToolBar();
        initListView();
    }

    private void initToolBar() {
        demoCityPickerMtb.setNavigationOnClickListener(view -> finish());
    }

    private void initListView() {
        List<AdapterDemoBean> list = new ArrayList<>();
        list.add(new AdapterDemoBean("样式一（仿 iOS 滚轮实现）", "在需要弹出的地方如EditText时弹出iOS风格城市选择器"));
        list.add(new AdapterDemoBean("样式一（仿iOS滚轮实现）自定义数据源", "自定义列表数据源，实现自定义数据源的城市选择器"));
        list.add(new AdapterDemoBean("样式二（城市一级列表展示）", "跳转新Activity展示城市一级列表"));
        list.add(new AdapterDemoBean("样式三（省市区三级列表）", "跳转新Activity展示城市三级列表"));
        list.add(new AdapterDemoBean("样式四（仿京东样式）", "仿京东样式的城市选择器"));

        List<HashMap<String, Object>> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            HashMap<String, Object> map1 = new HashMap<>();
            map1.put("title", list.get(i).getTitle());
            map1.put("subtitle", list.get(i).getSubTitle());
            list1.add(map1);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(customGetActivity(), list1, R.layout.demo_adapter_lv_item, new String[]{"title", "subtitle"}, new int[]{R.id.lv_item_tv_title, R.id.lv_item_tv_subtitle});
        demoCityPickerLv.setAdapter(simpleAdapter);

        demoCityPickerLv.setOnItemClickListener((adapterView, view, i, l) -> {
            switch (String.valueOf(list1.get(i).get("title"))) {
                case "样式一（仿 iOS 滚轮实现）":
                    customStart(CityPickerMainActivity.class);
                    break;
                case "样式一（仿iOS滚轮实现）自定义数据源":
                    customStart(CityPickerCustomDataActivity.class);
                    break;
                case "样式二（城市一级列表展示）":
                    customStart(CityPickerSingleListActivity.class);
                    break;
                case "样式三（省市区三级列表）":
                    customStart(CityPickerThreeListActivity.class);
                    break;
                case "样式四（仿京东样式）":
                    customStart(CityPickerJDActivity.class);
                    break;
            }
        });
    }

    private void initView() {
        demoCityPickerMtb = findViewById(R.id.demo_city_picker_mtb);
        demoCityPickerLv = findViewById(R.id.demo_city_picker_lv);
    }
}