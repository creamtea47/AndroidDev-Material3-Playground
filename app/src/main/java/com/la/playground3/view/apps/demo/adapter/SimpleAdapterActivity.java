package com.la.playground3.view.apps.demo.adapter;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.la.playground3.R;
import com.la.playground3.common.CustomActivity;
import com.la.playground3.databinding.ActivitySimpleAdapterBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * The type Simple adapter activity.
 */
public class SimpleAdapterActivity extends CustomActivity {
    /**
     * The Adapter.
     */
    SimpleAdapter adapter;
    /**
     * The List.
     */
    ArrayList<HashMap<String, String>> list;
    private ActivitySimpleAdapterBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivitySimpleAdapterBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        initTabBar();
        initBottomAppBar();
        initListView();
    }


    /**
     * <p>初始化 TabBar</p>
     */
    private void initTabBar() {
        mBinding.simpleAdapterMtb.setNavigationOnClickListener(view -> finish());
    }

    /**
     * <p>初始化 TabBar</p>
     */
    private void initBottomAppBar() {
        mBinding.simpleAdapterBab.setNavigationOnClickListener(view -> finish());
        mBinding.simpleAdapterFab.setOnClickListener(view -> {
            HashMap<String, String> map = new HashMap<>();
            map.put("title", "测试标题");
            map.put("subtitle", String.valueOf(new Random().nextLong()));
            list.add(map);
            mBinding.simpleAdapterLv.invalidateViews();// //listView刷新
            mBinding.simpleAdapterLv.setSelection(adapter.getCount());// 让listview滚动到底部
        });
    }

    /**
     * <p>初始化 ListView</p>
     */
    private void initListView() {
        String[] title = new String[]{"输入法列表", "添加 +，移除 -", "输入法列表", "添加 +，移除 -", "输入法列表", "添加 +，移除 -", "输入法偏好设置", "在菜单栏中显示输入法菜单", "自动切换到文稿的输入法。"};
        String[] subTitle = new String[]{"已启用可供使用的输入法。", "在列表中添加或移除输入法。", "已启用可供使用的输入法。", "在列表中添加或移除输入法。", "已启用可供使用的输入法。", "在列表中添加或移除输入法。", "如果所选输入法提供偏好设置，则它们将显示在右侧的区域中。例如，如果选择了“希伯来文”输入法，则会显示双向文本和键盘快捷键的选项。", "输入法菜单出现在菜单栏的右侧。此菜单包含启用的输入法以及可轻松访问的字符检视器和虚拟键盘，并提供在其间切换的快速方式。\n" +
                "\n" +
                "添加输入法时，将自动选择此选项。", "为文稿选取输入法并在每次处理文稿时使用它，直到关闭它；即使切换到同时使用其他输入法的其他文稿，也是如此。\n" +
                "\n" +
                "仅当添加第二个输入法时，才会显示此选项。"};
        list = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            HashMap<String, String> map = new HashMap<>();
            map.put("title", title[i]);
            map.put("subtitle", subTitle[i]);
            list.add(map);
        }

        adapter = new SimpleAdapter(customGetActivity(), list, R.layout.demo_simple_adapter_lv_item, new String[]{"title", "subtitle"}, new int[]{R.id.lv_item_tv_title, R.id.lv_item_tv_subtitle});
        mBinding.simpleAdapterLv.setAdapter(adapter);

        mBinding.simpleAdapterLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(customGetActivity());
                builder
                        .setTitle("标题")
                        .setIcon(R.drawable.baseline_self_improvement_24)
                        .setMessage("消息")
                        .setNegativeButton("NEG", null)
                        .setNeutralButton("NEU", null)
                        .setPositiveButton("POS", null)
                        .show();
            }
        });
    }
}