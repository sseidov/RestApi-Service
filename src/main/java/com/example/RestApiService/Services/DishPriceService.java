package com.example.RestApiService.Services;

import com.example.RestApiService.Entities.Dish.Dish;
import com.example.RestApiService.Entities.Dish.DishPrice;
import com.example.RestApiService.Exceptions.DishAlreadyExistException;
import com.example.RestApiService.Exceptions.DishNotExistException;
import com.example.RestApiService.Repositories.DishPriceRepository;
import com.example.RestApiService.Repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishPriceService {
    //Заменить тип инъекции
    @Autowired
    DishPriceRepository dishPriceRepository;
    @Autowired
    DishRepository dishRepository;

    public DishPrice addNewPriceToDish(DishPrice dishPrice, Long dishId) throws DishNotExistException {
        Dish dish = dishRepository.findById(dishId).get();

        if (dishRepository.findById(dishId).get() == null){
            throw new DishNotExistException("Данного блюда нет в меню.");
        }
        dishPrice.setDish(dish); // в поле dish_id -> dish
        return dishPriceRepository.save(dishPrice);
    }


}
