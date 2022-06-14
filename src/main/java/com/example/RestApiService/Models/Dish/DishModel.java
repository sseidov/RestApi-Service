package com.example.RestApiService.Models.Dish;

import com.example.RestApiService.Entities.Dish.Dish;
import com.example.RestApiService.Entities.Dish.DishPrice;

import java.util.List;
import java.util.stream.Collectors;

public class DishModel {

    private String name;
    private String ingredients;
    private double weight;
    private List<DishPrice> dishPriceList;


    public static DishModel toModel(Dish dish){
        DishModel dishModel = new DishModel();
        dishModel.setName(dish.getName());
        dishModel.setIngredients(dish.getIngredients());
        dishModel.setWeight(dish.getWeight());
//        dishModel.setDishPriceList(dish.getDishPriceList().stream().map(DishPriceModel::toModel).collect(Collectors.toList()));
        return dishModel;
    }

    public DishModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public List<DishPrice> getDishPriceList() {
        return dishPriceList;
    }

    public void setDishPriceList(List<DishPrice> dishPriceList) {
        this.dishPriceList = dishPriceList;
    }
}
