package com.mall.bean;

import java.io.Serializable;

/**
 * @author liuxiaojie
 *
 * 轮播图bean
 * */
public class Slider implements Serializable {
    private Long sid;  //主键 s_id
    private String stitle;  //主题 s_title
    private String spicurl;  //图片路径 s_picurl

    public Slider() {
    }

    public Slider(String stitle, String spicurl) {
        this.stitle = stitle;
        this.spicurl = spicurl;
    }

    @Override
    public String toString() {
        return "Slider{" +
                "sid=" + sid +
                ", stitle='" + stitle + '\'' +
                ", spicurl='" + spicurl + '\'' +
                '}';
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getStitle() {
        return stitle;
    }

    public void setStitle(String stitle) {
        this.stitle = stitle;
    }

    public String getSpicurl() {
        return spicurl;
    }

    public void setSpicurl(String spicurl) {
        this.spicurl = spicurl;
    }
}
