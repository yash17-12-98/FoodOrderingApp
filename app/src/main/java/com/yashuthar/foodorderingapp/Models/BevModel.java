package com.yashuthar.foodorderingapp.Models;

public class BevModel {
    int bevImage;
    String bevName, bevPrice, bevDescription;

    public BevModel(int bevImage, String bevName, String bevPrice, String bevDescription) {
        this.bevImage = bevImage;
        this.bevName = bevName;
        this.bevPrice = bevPrice;
        this.bevDescription = bevDescription;
    }

    public int getBevImage() {
        return bevImage;
    }

    public void setBevImage(int bevImage) {
        this.bevImage = bevImage;
    }

    public String getBevName() {
        return bevName;
    }

    public void setBevName(String bevName) {
        this.bevName = bevName;
    }

    public String getBevPrice() {
        return bevPrice;
    }

    public void setBevPrice(String bevPrice) {
        this.bevPrice = bevPrice;
    }

    public String getBevDescription() {
        return bevDescription;
    }

    public void setBevDescription(String bevDescription) {
        this.bevDescription = bevDescription;
    }
}
