package com.mall.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author liuxiaojie
 *
 * 种类bean
 * */
public class Venues implements Serializable {
    private Long vid;  //主键 v_id
    private String vtitle;  //主题 v_title
    private String vdecripte;  //  v_decripte
    private String vpicurl;  //图片存放路径 v_picurl

    private List<Details> detailses;  //详情list

    public Venues() {
    }

    public Venues(String vtitle, String vdecripte, String vpicurl, List<Details> detailses) {
        this.vtitle = vtitle;
        this.vdecripte = vdecripte;
        this.vpicurl = vpicurl;
        this.detailses = detailses;
    }

    @Override
    public String toString() {
        return "VenuesService{" +
                "vid=" + vid +
                ", vtitle='" + vtitle + '\'' +
                ", vdecripte='" + vdecripte + '\'' +
                ", vpicurl='" + vpicurl + '\'' +
                ", detailses=" + detailses +
                '}';
    }

    public Long getVid() {
        return vid;
    }

    public void setVid(Long vid) {
        this.vid = vid;
    }

    public String getVtitle() {
        return vtitle;
    }

    public void setVtitle(String vtitle) {
        this.vtitle = vtitle;
    }

    public String getVdecripte() {
        return vdecripte;
    }

    public void setVdecripte(String vdecripte) {
        this.vdecripte = vdecripte;
    }

    public String getVpicurl() {
        return vpicurl;
    }

    public void setVpicurl(String vpicurl) {
        this.vpicurl = vpicurl;
    }

    public List<Details> getDetailses() {
        return detailses;
    }

    public void setDetailses(List<Details> detailses) {
        this.detailses = detailses;
    }
}
