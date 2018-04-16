package com.mall.bean;

import java.io.Serializable;

/**
 * @author liuxiaojie
 *
 * 详情bean
 * */
public class Details implements Serializable {
    private Long did;  //主键  d_id
    private String dtitle;  //详情主题  d_title
    private String ddecripte;  //主题描述  d_decripte
    private String dpicurl;  //图片存放路径  d_picurl
    private String doldprice;  //原价  d_oldprice
    private String dnewprice;  //现价  d_newprice
    private Long vid;  //分类v_id

    public Details() {
    }

    public Details(String dtitle, String ddecripte, String dpicurl, String doldprice, String dnewprice, Long vid) {
        this.dtitle = dtitle;
        this.ddecripte = ddecripte;
        this.dpicurl = dpicurl;
        this.doldprice = doldprice;
        this.dnewprice = dnewprice;
        this.vid = vid;
    }

    @Override
    public String toString() {
        return "Details{" +
                "did=" + did +
                ", dtitle='" + dtitle + '\'' +
                ", ddecripte='" + ddecripte + '\'' +
                ", dpicurl='" + dpicurl + '\'' +
                ", doldprice='" + doldprice + '\'' +
                ", dnewprice='" + dnewprice + '\'' +
                ", vid=" + vid +
                '}';
    }

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }

    public String getDtitle() {
        return dtitle;
    }

    public void setDtitle(String dtitle) {
        this.dtitle = dtitle;
    }

    public String getDdecripte() {
        return ddecripte;
    }

    public void setDdecripte(String ddecripte) {
        this.ddecripte = ddecripte;
    }

    public String getDpicurl() {
        return dpicurl;
    }

    public void setDpicurl(String dpicurl) {
        this.dpicurl = dpicurl;
    }

    public String getDoldprice() {
        return doldprice;
    }

    public void setDoldprice(String doldprice) {
        this.doldprice = doldprice;
    }

    public String getDnewprice() {
        return dnewprice;
    }

    public void setDnewprice(String dnewprice) {
        this.dnewprice = dnewprice;
    }

    public Long getVid() {
        return vid;
    }

    public void setVid(Long vid) {
        this.vid = vid;
    }
}
