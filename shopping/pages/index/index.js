//获取应用实例
var app = getApp()

Page({

  /**
   * 页面的初始数据
   */
  data: {
    indicatorDots: true,
    vertical : false,
    autoplay: true,
    interval: 3000,
    duration: 1000,
    loadingHidden: false,
  },

  /**
   * 事件处理函数
  */
  swiperchange: function(e) {
    console.log(e.detail.current)
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function () {
    console.log('onLoad')
    var that = this

    //sliderList(轮播图list)
    wx.request({
      url: 'http://localhost:8080/index/sliderList',           //向后台发送请求
      method: 'GET',
      data:{},
      header:{
        'Accept':'application/json'
      },
      success: function(result) {
        that.setData({
          images:result.data          //将后台初始化的值赋值给页面
        })
      }
    })

    //venuesList(分类总列表)
    wx.request({
      url: 'http://localhost:8080/index/veunesList',          //向后台发送数据
      method: 'GET',
      data: {},
      header: {
        "Accept" : 'application/json'
      },
      success: function(result) {
        that.setData({
          venuesList: result.data            //将后台初始化的值赋值给页面
        })
        setTimeout(function(){
          that.setData({
            loadingHidden: true
          })
        },1500)
      }
    })
  }
})