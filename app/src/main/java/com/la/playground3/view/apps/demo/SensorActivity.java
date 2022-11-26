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
import com.la.playground3.view.apps.demo.sensor.SensoRedPacketDemoActivity;
import com.la.playground3.view.apps.demo.sensor.SensorMainDemoActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SensorActivity extends CustomActivity {

    private MaterialToolbar demoSensorMtb;
    private ListView demoSensorLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        initView();
        initToolBar();
        initListView();
    }

    private void initToolBar() {
        demoSensorMtb.setNavigationOnClickListener(view -> finish());
    }

    private void initView() {
        demoSensorMtb = (MaterialToolbar) findViewById(R.id.demo_dialog_mtb);
        demoSensorLv = (ListView) findViewById(R.id.demo_dialog_lv);
        demoSensorMtb = (MaterialToolbar) findViewById(R.id.demo_sensor_mtb);
        demoSensorLv = (ListView) findViewById(R.id.demo_sensor_lv);
    }

    private void initListView() {
        List<AdapterDemoBean> list = new ArrayList<>();
        list.add(new AdapterDemoBean("Demo1", "陀螺仪"));
        list.add(new AdapterDemoBean("Demo2", "摇一摇红包"));
//        list.add(new AdapterDemoBean("SimpleAdapter", "在 ArrayAdapter 的基础上，如果想要能够丰富地显示列表的信息，这时候则可以使用 SimpleAdapter。"));

        List<HashMap<String, Object>> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            HashMap<String, Object> map1 = new HashMap<>();
            map1.put("title", list.get(i).getTitle());
            map1.put("subtitle", list.get(i).getSubTitle());
            list1.add(map1);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(customGetActivity(), list1, R.layout.demo_adapter_lv_item, new String[]{"title", "subtitle"}, new int[]{R.id.lv_item_tv_title, R.id.lv_item_tv_subtitle});
        demoSensorLv.setAdapter(simpleAdapter);

        demoSensorLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (String.valueOf(list1.get(i).get("title"))) {
                    case "Demo1":
                        customStart(SensorMainDemoActivity.class);
                        break;
                    case "Demo2":
                        customStart(SensoRedPacketDemoActivity.class);
                }
            }
        });
    }

}