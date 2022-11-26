package com.la.playground3.view.apps.demo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by LuAng
 * Create Date 2022/7/8
 * <p>用于 BaseAdapterActivity 的适配器</p>
 * <p>继承 BaseAdapter 必须要实现它的 4 个方法</p>
 */
public abstract class MyBaseAdapter<T> extends BaseAdapter {
    int layoutId;
    List<T> data;

    public MyBaseAdapter(List<T> data, int layoutId) {
        this.layoutId = layoutId;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(layoutId, null);
        bindViewHolder(inflate, data.get(i), i);
        return inflate;
    }

    public abstract void bindViewHolder(View view, T item, int position);
}
