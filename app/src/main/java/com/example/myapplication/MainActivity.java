package com.example.myapplication;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.example.myapplication.common.CustomActivity;
import com.example.myapplication.util.ItemListDialogFragment;
import com.example.myapplication.view.apps.AppsFragment;
import com.example.myapplication.view.settings.SettingsFragment;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends CustomActivity {


    private MaterialToolbar mainTb;
    private FrameLayout mainFl;
    private BottomNavigationView mainBnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: 2022/6/27 调用初始化视图
        initView();

        // TODO: 2022/6/27 初始化Fragment
        FragmentManager fragmentTransaction = getSupportFragmentManager();
        fragmentTransaction.beginTransaction().add(R.id.main_fl, new AppsFragment()).commit();

        // TODO: 2022/6/28 BottomNavigationView点击事件
        mainBnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.apps:
                        fragmentTransaction.beginTransaction().setCustomAnimations(R.anim.alpha_in, R.anim.alpha_out).replace(R.id.main_fl, new AppsFragment()).addToBackStack(null).commit();
                        break;
                    case R.id.more:
                        ItemListDialogFragment.newInstance(30).show(getSupportFragmentManager(), "dialog");
                        customToast("敬请期待～");
                        break;
                    case R.id.setting:
                        fragmentTransaction.beginTransaction().setCustomAnimations(R.anim.alpha_in, R.anim.alpha_out).replace(R.id.main_fl, new SettingsFragment()).addToBackStack(null).commit();
                        break;
                }
                return false;
            }
        });

    }


    private void initView() {
        mainTb = (MaterialToolbar) findViewById(R.id.main_tb);
        mainFl = (FrameLayout) findViewById(R.id.main_fl);
        mainBnv = (BottomNavigationView) findViewById(R.id.main_bnv);
    }
}