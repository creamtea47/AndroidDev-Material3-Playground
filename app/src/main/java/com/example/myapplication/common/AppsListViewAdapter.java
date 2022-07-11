package com.example.myapplication.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.entity.AppsListViewBean;

import java.util.ArrayList;

/**
 * Created by LuAng
 * Create Date 2022/7/3 Apps ListView适配器
 * Used
 */
public class AppsListViewAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<AppsListViewBean> mList;

    public AppsListViewAdapter(Context context, ArrayList<AppsListViewBean> appsListViewBeans) {
        this.mContext = context;
        this.mList = appsListViewBeans;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.apps_lv_item, null);
            viewHolder.id = view.findViewById(R.id.lv_item_tv_id);
            viewHolder.title = view.findViewById(R.id.lv_item_tv_title);
            viewHolder.subtitle = view.findViewById(R.id.lv_item_tv_subtitle);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.id.setText("" + mList.get(i).getId());
        viewHolder.title.setText(mList.get(i).getTitle());
        viewHolder.subtitle.setText(mList.get(i).getSubtitle());
        return view;
    }

    public class ViewHolder {
        public TextView id;
        public TextView title;
        public TextView subtitle;
    }
}
