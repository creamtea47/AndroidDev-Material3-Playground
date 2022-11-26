package com.la.playground3.entity;

/**
 * Created by LuAng
 * Create Date 2022/7/3 Apps列表实体类
 * Used
 */
public class AppsListViewBean {
    private String id;
    private String title;
    private String subtitle;

    public AppsListViewBean(String id, String title, String subtitle) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
