package com.example.myapplication.view.apps.demo.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by LuAng
 * Create Date 2022/7/8 用于 BaseAdapterActivity 的适配器
 * Used
 */
public class MyBaseAdapter extends BaseAdapter {
    /**
     * <p style="color:red">会首先执行这个方法！（且连续执行好几次）</p>
     *
     * @return 返回适配器中所代表的数据集合的条数
     */
    @Override
    public int getCount() {
        return 0;
    }

    /**
     * @param i
     * @return
     */
    @Override
    public Object getItem(int i) {
        return null;
    }

    /**
     * @param i
     * @return
     */
    @Override
    public long getItemId(int i) {
        return 0;
    }

    /**
     * @param i
     * @param view
     * @param viewGroup
     * @return
     */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
