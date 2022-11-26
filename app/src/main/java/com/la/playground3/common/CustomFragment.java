package com.la.playground3.common;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

/**
 * Created by LuAng
 * Create Date 2022/6/28 封装fragment父类方法
 * Used
 */
public class CustomFragment extends Fragment {
    public Activity customGetActivity() {
        return getActivity();
    }

    public void customToast(String msg) {
        Toast.makeText(customGetActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    public void customStart(Class targetClass) {
        startActivity(new Intent(customGetActivity(), targetClass));
    }
}
