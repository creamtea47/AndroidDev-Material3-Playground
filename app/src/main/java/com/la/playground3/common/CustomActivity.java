package com.la.playground3.common;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class CustomActivity extends AppCompatActivity {

    // TODO: 2022/6/27 封装方法：获取当前Activity
    public Activity customGetActivity() {
        return this;
    }

    // TODO: 2022/6/27 封装方法：Toast消息
    public void customToast(String msg) {
        Toast.makeText(customGetActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    public void customStart(Class targetClass) {
        startActivity(new Intent(customGetActivity(), targetClass));
    }

    public void customDialog(String title, String message) {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(customGetActivity());
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null)
                .show();
    }

}
