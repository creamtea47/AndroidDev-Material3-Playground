package com.example.myapplication.view.apps;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.example.myapplication.common.AppsListViewAdapter;
import com.example.myapplication.common.CustomFragment;
import com.example.myapplication.entity.AppsListViewBean;
import com.example.myapplication.view.apps.demo.AdapterActivity;
import com.example.myapplication.view.apps.demo.ChipActivity;
import com.example.myapplication.view.apps.demo.DialogActivity;

import java.util.ArrayList;
import java.util.List;


/**
 * The type Apps fragment.
 */
public class AppsFragment extends CustomFragment {
    /**
     * The View.
     */
    View view;
    private ListView appsLv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_apps, container, false);
        initView();

        List<AppsListViewBean> list = new ArrayList<>();
        list.add(new AppsListViewBean("适", "适配器用例", "Adapter 对象"));
        list.add(new AppsListViewBean("C", "Material Chips", "Material Chips 用例"));
        list.add(new AppsListViewBean("M", "Material Dialogs", "Material Dialogs 对话框"));

        AppsListViewAdapter appsListViewAdapter = new AppsListViewAdapter(customGetActivity(), (ArrayList<AppsListViewBean>) list);
        appsLv.setAdapter(appsListViewAdapter);
        appsLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (list.get(i).getTitle()) {
                    case "适配器用例":
                        customStart(AdapterActivity.class);
                        break;
                    case "Material Chips":
                        customStart(ChipActivity.class);
                        break;
                    case "Material Dialogs":
                        customStart(DialogActivity.class);
                        break;
                }
            }
        });

        return view;
    }

    private void initView() {
        appsLv = (ListView) view.findViewById(R.id.apps_lv);
    }
}