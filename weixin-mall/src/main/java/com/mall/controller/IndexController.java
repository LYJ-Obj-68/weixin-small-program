package com.mall.controller;

/**
 * @author liuxiaojie
 *
 * 首页所有显示信息Controller
 * */

import com.mall.bean.Details;
import com.mall.bean.Slider;
import com.mall.bean.Venues;
import com.mall.service.DetailsService;
import com.mall.service.SliderService;
import com.mall.service.VenuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author liuxiaojie
 *
 * 首页内容Controller
 * */
@RestController
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private SliderService sliderService;
    @Autowired
    private VenuesService venuesService;
    @Autowired
    private DetailsService detailsService;

    //返回轮播图信息
    @GetMapping("/sliderList")
    public List<Slider> listSliders () {
        List<Slider> sliders = sliderService.listSliders();
        return sliders;
    }

    //返回分类表信息
    @GetMapping("veunesList")
    public List<Object> listVenues () {
        List<Object> venueses = venuesService.listAll();
        return venueses;
    }

    //返回详情表所有信息
    @GetMapping("detailstList")
    public List<Object> listDetails () {
        List<Object> detailses = detailsService.listAll();
        return detailses;
    }

    //根据分类表vid获取详情列表list
    @GetMapping("detailsListByvid/vid={vid}")
    public List<Details> listDetailsByVid (@PathVariable("vid") Long vid) {
        return detailsService.listByVid(vid);
    }

    //根据商品详情did获取对象信息
    @GetMapping("getDetailsById/did={did}")
    public Details getDetailsByDid (@PathVariable("did") Long did) {
        return (Details) detailsService.getById(did);
    }
}
