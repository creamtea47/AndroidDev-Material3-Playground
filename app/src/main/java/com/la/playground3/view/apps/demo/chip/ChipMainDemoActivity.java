package com.la.playground3.view.apps.demo.chip;

import android.os.Bundle;

import com.la.playground3.common.CustomActivity;
import com.la.playground3.databinding.ActivityChipMainDemoBinding;

public class ChipMainDemoActivity extends CustomActivity {
    private ActivityChipMainDemoBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityChipMainDemoBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        initToolBar();
    }

    /**
     * <p>初始化 ToolBar</p>
     */
    private void initToolBar() {
        mBinding.chipMainMtb.setNavigationOnClickListener(view -> finish());
    }
}