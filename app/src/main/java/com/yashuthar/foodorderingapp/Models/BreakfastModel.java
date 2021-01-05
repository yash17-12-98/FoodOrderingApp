package com.yashuthar.foodorderingapp.Models;

public class BreakfastModel {
    int bfImage;
    String bfName, bfPrice, bfDescription;

    public BreakfastModel(int bfImage, String bfName, String bfPrice, String bfDescription) {
        this.bfImage = bfImage;
        this.bfName = bfName;
        this.bfPrice = bfPrice;
        this.bfDescription = bfDescription;
    }

    public int getBfImage() {
        return bfImage;
    }

    public void setBfImage(int bfImage) {
        this.bfImage = bfImage;
    }

    public String getBfName() {
        return bfName;
    }

    public void setBfName(String bfName) {
        this.bfName = bfName;
    }

    public String getBfPrice() {
        return bfPrice;
    }

    public void setBfPrice(String bfPrice) {
        this.bfPrice = bfPrice;
    }

    public String getBfDescription() {
        return bfDescription;
    }

    public void setBfDescription(String bfDescription) {
        this.bfDescription = bfDescription;
    }
}
