package com.la.playground3.view.apps.demo.adapter;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.la.playground3.R;
import com.la.playground3.databinding.ActivityBaseAdapterBinding;

import java.util.ArrayList;
import java.util.List;

public class BaseAdapterActivity extends AppCompatActivity {
    private ActivityBaseAdapterBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityBaseAdapterBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        initToolBar();
        initListView();
    }

    /**
     * <p>初始化 ToolBar</p>
     */
    private void initToolBar() {
        mBinding.baseAdapterMtb.setNavigationOnClickListener(view -> finish());
    }


    /**
     * <p>初始化 ListView</p>
     */
    private void initListView() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("Item " + i);
        }
        mBinding.baseAdapterLv.setAdapter(new MyBaseAdapter<String>(list, R.layout.demo_adapter_lv_item) {
            private TextView lvItemTvSubtitle;
            private TextView lvItemTvTitle;

            private void initView(View view) {
                lvItemTvTitle = (TextView) view.findViewById(R.id.lv_item_tv_title);
                lvItemTvSubtitle = (TextView) view.findViewById(R.id.lv_item_tv_subtitle);
            }

            @Override
            public void bindViewHolder(View view, String item, int position) {
                initView(view);
                lvItemTvTitle.setText(item);
                lvItemTvSubtitle.setText("Subtitle " + position);
            }
        });
    }

}