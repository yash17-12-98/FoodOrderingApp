package com.yashuthar.foodorderingapp.Models;

public class OrderModel {
    int orderImage;
    String orderName, orderId, orderPrice;

    public OrderModel(int orderImage, String orderName, String orderId, String orderPrice) {
        this.orderImage = orderImage;
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderPrice = orderPrice;
    }

    public OrderModel() {

    }


    public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }
}
