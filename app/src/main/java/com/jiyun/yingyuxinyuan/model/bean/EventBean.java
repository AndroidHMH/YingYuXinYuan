package com.jiyun.yingyuxinyuan.model.bean;

/**
 * Created by asus on 2018/5/4.
 */

public class EventBean {
    private String fragmentTitle;

    public EventBean() {
    }

    public EventBean(String fragmentTitle) {
        this.fragmentTitle = fragmentTitle;
    }

    public String getFragmentTitle() {
        return fragmentTitle;
    }

    public void setFragmentTitle(String fragmentTitle) {
        this.fragmentTitle = fragmentTitle;
    }
}
