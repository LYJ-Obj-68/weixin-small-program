//list.js
var app = getApp()

Page({

  /**
   * 页面的初始数据
   */
  data: {
    
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this           //将当前页面的所有数据赋值给 that
    wx.request({
      url: 'http://localhost:8080/index/detailsListByvid/vid='+options.vid,     //向后台发送请求并传递参数
      method:'GET',
      data:{},
      header:{
        'Accept':'application/json'
      },
      success: function(result) {
        that.setData({
          detailList:result.data           //将后台数据赋值给页面
        })
      }
    })
  }
})