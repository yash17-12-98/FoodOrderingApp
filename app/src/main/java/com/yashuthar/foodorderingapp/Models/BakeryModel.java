package com.yashuthar.foodorderingapp.Models;

public class BakeryModel {
    int bakImage;
    String bakName, bakPrice, bakDescription;

    public BakeryModel(int bakImage, String bakName, String bakPrice, String bakDescription) {
        this.bakImage = bakImage;
        this.bakName = bakName;
        this.bakPrice = bakPrice;
        this.bakDescription = bakDescription;
    }

    public int getBakImage() {
        return bakImage;
    }

    public void setBakImage(int bakImage) {
        this.bakImage = bakImage;
    }

    public String getBakName() {
        return bakName;
    }

    public void setBakName(String bakName) {
        this.bakName = bakName;
    }

    public String getBakPrice() {
        return bakPrice;
    }

    public void setBakPrice(String bakPrice) {
        this.bakPrice = bakPrice;
    }

    public String getBakDescription() {
        return bakDescription;
    }

    public void setBakDescription(String bakDescription) {
        this.bakDescription = bakDescription;
    }
}
