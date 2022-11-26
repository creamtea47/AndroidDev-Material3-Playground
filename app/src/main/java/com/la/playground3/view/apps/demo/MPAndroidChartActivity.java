package com.la.playground3.view.apps.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.google.android.material.appbar.MaterialToolbar;
import com.la.playground3.R;
import com.la.playground3.common.CustomActivity;
import com.la.playground3.entity.AdapterDemoBean;
import com.la.playground3.view.apps.demo.chart.MPAndroidChartMainActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MPAndroidChartActivity extends CustomActivity {


    private MaterialToolbar demoMpandroidChartMtb;
    private ListView demoMpandroidChartLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpandroid_chart);
        initView();
        initToolBar();
        initListView();
    }

    private void initToolBar() {
        demoMpandroidChartMtb.setNavigationOnClickListener(view -> finish());
    }


    private void initListView() {
        List<AdapterDemoBean> list = new ArrayList<>();
        list.add(new AdapterDemoBean("Demo", "MPAndroidChartMainActivity"));

        List<HashMap<String, Object>> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            HashMap<String, Object> map1 = new HashMap<>();
            map1.put("title", list.get(i).getTitle());
            map1.put("subtitle", list.get(i).getSubTitle());
            list1.add(map1);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(customGetActivity(), list1, R.layout.demo_adapter_lv_item, new String[]{"title", "subtitle"}, new int[]{R.id.lv_item_tv_title, R.id.lv_item_tv_subtitle});
        demoMpandroidChartLv.setAdapter(simpleAdapter);

        demoMpandroidChartLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (String.valueOf(list1.get(i).get("title"))) {
                    case "Demo":
                        customStart(MPAndroidChartMainActivity.class);
                        break;
                    case "Demo2":
//                        customStart(SensoRedPacketDemoActivity.class);
                        break;
                }
            }
        });
    }

    private void initView() {
        demoMpandroidChartMtb = (MaterialToolbar) findViewById(R.id.demo_mpandroid_chart_mtb);
        demoMpandroidChartLv = (ListView) findViewById(R.id.demo_mpandroid_chart_lv);
    }
}