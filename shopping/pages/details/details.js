//details.js
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
    var that = this

    //商品详情
    wx.request({
      url: 'http://localhost:8080/index/getDetailsById/did='+options.did,
      method: 'GET',
      data: {},
      header: {
        'Accept': 'application/json'
      },
      success: function(result) {
        that.setData({
          details: result.data
        })
      }
    })
  },

  /**
   * 将商品添加到购物车
  */
  addCarts:function(options) {
    //移除购物车中的商品信息
    //wx.removeStorageSync('cart');
    //获取当前商品id
    let did = options.target.dataset.did
    //获取details中的商品信息，此商品将被添加到购物车
    let product = this.data.details
    /**
     * 从本地存储中获取购物车中的所有商品信息列表，若本地存储中没有，则初始化为[]
     * cartProducts保存的数据结构如下：
     * [{},{}]
     * [
     *  {
     *    details:{},
     *    count:1,
     *    isSelect:false,
     *  },
     *  {
     *    details:{},
     *    count:2,
     *    isSelect:false,
     *  }
     * ]
    */
    let cartProducts = wx.getStorageSync('cart') || []
    //将当前商品标记为  未添加到购物车
    let isAddToCart = false;

    //先遍历购物车中的所有商品
    cartProducts.forEach(function (cartProduct, did) {
      //判断购物车中是否存在此商品，若存在，则数量加 1 ，并且将此商品状态改为  true
      if (cartProduct.product.did === product.did) {
        cartProduct.count++;
        isAddToCart = true;
      }
    })

    //若购物车中没有存在此商品，如下处理
    if (!isAddToCart) {
      //组装json对象(商品+数量+是否选中状态(购物车中需要引用))，因商品是初始加入，所以count=1
      let setCartProduct = {
        product: product,
        count: 1,
        isSelect:false
      }
      //将组装好的json对象添加到购物车列表中
      cartProducts.unshift(setCartProduct);
    }
    //将购物车信息存储到本地存储中
    wx.setStorageSync('cart', cartProducts);
  }
})