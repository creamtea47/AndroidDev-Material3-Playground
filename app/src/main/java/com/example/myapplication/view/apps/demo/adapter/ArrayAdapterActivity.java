package com.example.myapplication.view.apps.demo.adapter;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import com.example.myapplication.R;
import com.example.myapplication.common.CustomActivity;
import com.example.myapplication.databinding.ActivityArrayAdapterBinding;
import com.google.android.material.chip.ChipGroup;

/**
 * The type Array adapter activity.
 */
public class ArrayAdapterActivity extends CustomActivity {
    private ActivityArrayAdapterBinding mBinding;
    String[] name;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityArrayAdapterBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        initTabBar();
        initListView();
        initChipGroup();
    }


    /**
     * <p>初始化 TabBar</p>
     */
    private void initTabBar() {
        mBinding.arrayAdapterMtb.setNavigationOnClickListener(new View.OnClickListener() {
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
        name = new String[]{"歌单被收臧", "电台被订阅", "收到赞", "启用系统款曲播放通知栏", "使用系统媒体快捷键", "启用款词"};
        adapter = new ArrayAdapter(customGetActivity(), android.R.layout.simple_list_item_1, name);
        mBinding.arrayAdapterLv.setAdapter(adapter);
    }

    /**
     * <p>初始化 ChipGroup,Chip</p>
     */
    private void initChipGroup() {
        mBinding.arrayAdapterCg.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull ChipGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.array_adapter_c1:
                        adapter = new ArrayAdapter(customGetActivity(), android.R.layout.simple_list_item_1, name);
                        mBinding.arrayAdapterLv.setAdapter(adapter);
                        mBinding.arrayAdapterLv.setChoiceMode(AbsListView.CHOICE_MODE_NONE);
                        break;
                    case R.id.array_adapter_c2:
                        adapter = new ArrayAdapter(customGetActivity(), android.R.layout.simple_list_item_checked, name);
                        mBinding.arrayAdapterLv.setAdapter(adapter);
                        mBinding.arrayAdapterLv.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
                        break;
                    case R.id.array_adapter_c3:
                        adapter = new ArrayAdapter(customGetActivity(), android.R.layout.simple_list_item_multiple_choice, name);
                        mBinding.arrayAdapterLv.setAdapter(adapter);
                        mBinding.arrayAdapterLv.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
                        break;
                    case R.id.array_adapter_c4:
                        adapter = new ArrayAdapter(customGetActivity(), android.R.layout.simple_list_item_single_choice, name);
                        mBinding.arrayAdapterLv.setAdapter(adapter);
                        mBinding.arrayAdapterLv.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
                        break;
                }
            }
        });
    }


}