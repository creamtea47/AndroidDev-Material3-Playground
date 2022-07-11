package com.example.myapplication.entity;

/**
 * Created by LuAng
 * Create Date 2022/7/6
 * Used
 */
public class AdapterDemoBean {
    private String Title;
    private String SubTitle;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getSubTitle() {
        return SubTitle;
    }

    public void setSubTitle(String subTitle) {
        SubTitle = subTitle;
    }

    public AdapterDemoBean(String title, String subTitle) {
        Title = title;
        SubTitle = subTitle;
    }
}
