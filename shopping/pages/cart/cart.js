//获取应用实例
var app = getApp()

Page({

  /**
   * 页面的初始数据
   */
  data: {
    cart: [],
    totalPay: 0,  //商品总价
    selectAllStatus:false,  //是否全选
  },
  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    //获取到购物车中所有商品信息
    this.setData({
      cart: wx.getStorageSync('cart') || []
    })
    this.getTotalPrice();
  },
  /**
   * 删除商品，并计算总价
   * 点击删除按钮则从购物车列表中删除当前元素，删除之后如果购物车为空，改变购物车为空标识hasList为false
  */
  removeProduct: function(options) {
    const index = options.target.dataset.index;  // 获取要删除的购物车商品的索引(删除的是整个商品，不是具体指的那个商品，因此不能根据id获取)
    let carts = this.data.cart;        // 当前购物车里的所有商品信息(之前组装好的json对象(商品信息+数量+选中状态))
    carts.splice(index, 1);              // 删除购物车列表里这个商品
    this.setData({
      cart: carts
    });
    this.getTotalPrice();           // 重新计算总价格
    wx.setStorageSync('cart', this.data.cart) // 把更新后的商品信息重新保存到本地存储中
  },
  /**
   * 计算商品总价(总价 = 选中的商品1的 价格 * 数量 + 选中的商品2的 价格 * 数量 + ...)
   * 选中、取消、删除商品都需要计算价格
  */
  getTotalPrice:function() {
    let carts = this.data.cart;                  // 获取购物车列表
    let paymoney = 0
    for (let i = 0; i < carts.length; i++) {         // 循环列表得到每个数据
      if (carts[i].isSelect) {                   // 判断选中才会计算价格
        paymoney += carts[i].count * carts[i].product.dnewprice;     // 所有价格加起来
      }
    }
    this.setData({                              // 最后赋值到data中渲染到页面
      totalPay: paymoney.toFixed(2)             //将设置好的总价保留两位小数(四舍五入)
    })
  },
  /**
   * 商品单选事件
   * 点击时选中，再点击又变成没选中状态，其实就是改变 isSelect 字段;
   * 通过 data-index="{{index}}" 把当前商品在列表数组中的下标传给事件;并计算总价
   * 
  */
  selectList:function (options) {
    const index = options.target.dataset.index;    // 获取data- 传进来的index
    let carts = this.data.cart;                    // 获取购物车列表
    const isSelect = carts[index].isSelect;         // 获取当前商品的选中状态
    carts[index].isSelect = !isSelect;              // 改变状态
    this.setData({
      cart: carts
    });
    this.getTotalPrice();                           // 重新获取总价
    wx.setStorageSync('cart', this.data.cart)       // 把更新后的商品信息重新保存到本地存储中
  },
  /**
   * 商品是否全选(全选就是根据全选状态 selectAllStatus 去改变每个商品的 isSelect)
   * 当全选(取消)后全部商品的状态改变，并且计算总价
  */
  selectAll: function(options) {
    let selectAllStatus = this.data.selectAllStatus;    // 是否全选状态
    selectAllStatus = !selectAllStatus;
    let carts = this.data.cart;
    for (let i = 0; i < carts.length; i++) {
      carts[i].isSelect = selectAllStatus;            // 改变所有商品状态
    }
    this.setData({
      selectAllStatus: selectAllStatus,
      cart: carts
    });
    this.getTotalPrice();                               // 重新获取总价
    wx.setStorageSync('cart', this.data.cart)           // 把更新后的商品信息重新保存到本地存储中
  },
  /**
   * 增加数量
  */
  addCount: function(options) {
    const index = options.target.dataset.index;
    let carts = this.data.cart;
    let count = carts[index].count;
    count = count + 1;
    carts[index].count = count;
    this.setData({
      cart: carts
    });
    this.getTotalPrice();
    wx.setStorageSync('cart', this.data.cart)           // 把更新后的商品信息重新保存到本地存储中
  },
  /**
   * 减少数量
   * */ 
  minusCount: function(options) {
    const index = options.currentTarget.dataset.index;
    let carts = this.data.cart;
    let count = carts[index].count;
    if (count <= 1) {
      return false;
    }
    count = count - 1;
    carts[index].count = count;
    this.setData({
      cart: carts
    });
    this.getTotalPrice();
    wx.setStorageSync('cart', this.data.cart)           // 把更新后的商品信息重新保存到本地存储中
  }
})