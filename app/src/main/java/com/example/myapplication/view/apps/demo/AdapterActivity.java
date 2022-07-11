package com.example.myapplication.view.apps.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;

import com.example.myapplication.R;
import com.example.myapplication.common.CustomActivity;
import com.example.myapplication.databinding.ActivityAdapterBinding;
import com.example.myapplication.entity.AdapterDemoBean;
import com.example.myapplication.view.apps.demo.adapter.ArrayAdapterActivity;
import com.example.myapplication.view.apps.demo.adapter.SimpleAdapterActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The type Adapter activity.
 */
public class AdapterActivity extends CustomActivity {
    private ActivityAdapterBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityAdapterBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        initToolBar();
        initListView();
    }

    /**
     * <p>初始化 ToolBar</p>
     */
    private void initToolBar() {
        mBinding.demoAdapterTb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    /**
     * <p>初始化 ListView</p>
     */
    private void initListView() {
        List<AdapterDemoBean> list = new ArrayList<>();
        list.add(new AdapterDemoBean("ArrayAdapter", "ArrayAdapter 支持泛型操作，是最简单的一个 Adapter，但是只能展现一行文字。"));
        list.add(new AdapterDemoBean("SimpleAdapter", "在 ArrayAdapter 的基础上，如果想要能够丰富地显示列表的信息，这时候则可以使用 SimpleAdapter。"));
        list.add(new AdapterDemoBean("BaseAdapter", "我们在实际开发过程中接触最多的就是 BaseAdapter 了。可以最大程度的定制我们自己的 item。"));

        List<HashMap<String, Object>> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            HashMap<String, Object> map1 = new HashMap<>();
            map1.put("title", list.get(i).getTitle());
            map1.put("subtitle", list.get(i).getSubTitle());
            list1.add(map1);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(customGetActivity(), list1, R.layout.demo_adapter_lv_item, new String[]{"title", "subtitle"}, new int[]{R.id.lv_item_tv_title, R.id.lv_item_tv_subtitle});
        mBinding.demoAdapterLv.setAdapter(simpleAdapter);

        mBinding.demoAdapterLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (String.valueOf(list1.get(i).get("title"))) {
                    case "ArrayAdapter":
                        customStart(ArrayAdapterActivity.class);
                        break;
                    case "SimpleAdapter":
                        customStart(SimpleAdapterActivity.class);
                        break;
                }
            }
        });
    }
}