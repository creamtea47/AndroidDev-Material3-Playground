package com.example.myapplication.view.apps.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;

import com.example.myapplication.R;
import com.example.myapplication.common.CustomActivity;
import com.example.myapplication.databinding.ActivityChipBinding;
import com.example.myapplication.entity.AdapterDemoBean;
import com.example.myapplication.view.apps.demo.chip.ChipMainDemoActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChipActivity extends CustomActivity {
    private ActivityChipBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityChipBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        initToolBar();
        initListView();
    }

    /**
     * <p>初始化 ToolBar</p>
     */
    private void initToolBar() {
        mBinding.demoChipsMtb.setNavigationOnClickListener(view -> finish());
    }

    /**
     * <p>初始化 ListView</p>
     */
    private void initListView() {
        List<AdapterDemoBean> list = new ArrayList<>();
        list.add(new AdapterDemoBean("Demo", "ChipMainDemoActivity"));
//        list.add(new AdapterDemoBean("SimpleAdapter", "在 ArrayAdapter 的基础上，如果想要能够丰富地显示列表的信息，这时候则可以使用 SimpleAdapter。"));

        List<HashMap<String, Object>> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            HashMap<String, Object> map1 = new HashMap<>();
            map1.put("title", list.get(i).getTitle());
            map1.put("subtitle", list.get(i).getSubTitle());
            list1.add(map1);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(customGetActivity(), list1, R.layout.demo_adapter_lv_item, new String[]{"title", "subtitle"}, new int[]{R.id.lv_item_tv_title, R.id.lv_item_tv_subtitle});
        mBinding.demoChipsLv.setAdapter(simpleAdapter);

        mBinding.demoChipsLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (String.valueOf(list1.get(i).get("title"))) {
                    case "Demo":
                        customStart(ChipMainDemoActivity.class);
                        break;
                }
            }
        });
    }
}