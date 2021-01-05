package com.yashuthar.foodorderingapp.Models;

public class BurgerModel {
    int burgerImage;
    String burgerName, burgerPrice, burgerDescription;

    public BurgerModel(int burgerImage, String burgerName, String burgerPrice, String burgerDescription) {
        this.burgerImage = burgerImage;
        this.burgerName = burgerName;
        this.burgerPrice = burgerPrice;
        this.burgerDescription = burgerDescription;
    }

    public int getBurgerImage() {
        return burgerImage;
    }

    public void setBurgerImage(int burgerImage) {
        this.burgerImage = burgerImage;
    }

    public String getBurgerName() {
        return burgerName;
    }

    public void setBurgerName(String burgerName) {
        this.burgerName = burgerName;
    }

    public String getBurgerPrice() {
        return burgerPrice;
    }

    public void setBurgerPrice(String burgerPrice) {
        this.burgerPrice = burgerPrice;
    }

    public String getBurgerDescription() {
        return burgerDescription;
    }

    public void setBurgerDescription(String burgerDescription) {
        this.burgerDescription = burgerDescription;
    }
}
