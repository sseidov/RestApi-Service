package com.example.RestApiService.Models.Dish;


import com.example.RestApiService.Entities.Dish.DishPrice;

import java.util.Date;

public class DishPriceModel {

    private Date date_from;
    private Double price;

    public static DishPriceModel toModel(DishPrice dishPrice){
    DishPriceModel dishPriceModel = new DishPriceModel();
    dishPriceModel.setPrice(dishPriceModel.getPrice());
    dishPriceModel.setDate_from(dishPrice.getDate_from());
    return dishPriceModel;
    }
    public DishPriceModel() {
    }

    public Date getDate_from() {
        return date_from;
    }

    public void setDate_from(Date date_from) {
        this.date_from = date_from;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
