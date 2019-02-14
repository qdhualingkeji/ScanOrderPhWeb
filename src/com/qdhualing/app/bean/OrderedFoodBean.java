package com.qdhualing.app.bean;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by asus on 2017/11/3.
 */

public class OrderedFoodBean {
    String orderNumber; //订单�?
    String orderTime; //下单时间
    String commitTime; //提交时间
    int orderState; //订单状�??
    int  isCollect; //是否收藏 0未收藏，�?１收�?
    List<OrderFoodBean> productList = new ArrayList<OrderFoodBean>(); //下单产品列表

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(String commitTime) {
        this.commitTime = commitTime;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public int getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(int isCollect) {
        this.isCollect = isCollect;
    }

    public List<OrderFoodBean> getProductList() {
        return productList;
    }

    public void setProductList(List<OrderFoodBean> productList) {
        this.productList = productList;
    }
}
