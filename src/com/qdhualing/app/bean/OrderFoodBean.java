package com.qdhualing.app.bean;

/**
 * Created by asus on 2017/11/3.
 */

public class OrderFoodBean {
    private Integer id;
    private Integer productId; //产品id
    private String productName; //产品名字
    private Integer quantity; //数量
    private Double price; //价格
    private Integer orderId; //订单表主键id
    private Integer state; // 状�?:是否新增 0否，1�?
    private Integer categoryId; //�?��分类id
    private String imgUrl;
    private String categoryName; //分类名称

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "{productId:"+id+",productName:"+productName+",quantity:"+quantity+",price:"+price+"}";
    }
}
