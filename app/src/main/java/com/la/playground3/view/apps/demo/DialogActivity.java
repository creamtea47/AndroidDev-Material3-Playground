package com.la.playground3.view.apps.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;

import com.la.playground3.R;
import com.la.playground3.common.CustomActivity;
import com.la.playground3.databinding.ActivityDialogBinding;
import com.la.playground3.entity.AdapterDemoBean;
import com.la.playground3.view.apps.demo.dialog.DialogMainDemoActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DialogActivity extends CustomActivity {
    private ActivityDialogBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mBinding = ActivityDialogBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(mBinding.getRoot());

        initToolBar();
        initListView();
    }

    /**
     * <p>初始化 ToolBar</p>
     */
    private void initToolBar() {
        mBinding.demoDialogMtb.setNavigationOnClickListener(view -> finish());
    }

    /**
     * <p>初始化 ListView</p>
     */
    private void initListView() {
        List<AdapterDemoBean> list = new ArrayList<>();
        list.add(new AdapterDemoBean("Demo", "DialogMainDemoActivity"));
//        list.add(new AdapterDemoBean("SimpleAdapter", "在 ArrayAdapter 的基础上，如果想要能够丰富地显示列表的信息，这时候则可以使用 SimpleAdapter。"));

        List<HashMap<String, Object>> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            HashMap<String, Object> map1 = new HashMap<>();
            map1.put("title", list.get(i).getTitle());
            map1.put("subtitle", list.get(i).getSubTitle());
            list1.add(map1);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(customGetActivity(), list1, R.layout.demo_adapter_lv_item, new String[]{"title", "subtitle"}, new int[]{R.id.lv_item_tv_title, R.id.lv_item_tv_subtitle});
        mBinding.demoDialogLv.setAdapter(simpleAdapter);

        mBinding.demoDialogLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if ("Demo".equals(String.valueOf(list1.get(i).get("title")))) {
                    customStart(DialogMainDemoActivity.class);
                }
            }
        });
    }
}