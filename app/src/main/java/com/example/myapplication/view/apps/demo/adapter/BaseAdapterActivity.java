package com.example.myapplication.view.apps.demo.adapter;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityBaseAdapterBinding;

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
        List<User> list = new ArrayList<>();
        list.add(new User(1, "test01", "password"));
    }


    /**
     * <p>数据源</p>
     */
    class User {
        private int id;
        private String username;
        private String password;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public User(int id, String username, String password) {
            this.id = id;
            this.username = username;
            this.password = password;
        }
    }
}