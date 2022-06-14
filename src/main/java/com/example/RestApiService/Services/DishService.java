package com.example.RestApiService.Services;

import com.example.RestApiService.Entities.Dish.Dish;
import com.example.RestApiService.Exceptions.DishAlreadyExistException;
import com.example.RestApiService.Exceptions.DishNotExistException;
import com.example.RestApiService.Repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishService {
//  Заменить тип инъекции
    @Autowired
    DishRepository dishRepository;

    public Dish addNewDish (Dish dish) throws DishAlreadyExistException {
        if (dishRepository.findByName(dish.getName()) != null){
            throw new DishAlreadyExistException("Блюдо с таким названием уже существует.");
        }
        return dishRepository.save(dish);
    }

    public Dish updateDish(Long id, Dish changedDish) throws DishNotExistException{
        Dish dish = dishRepository.findById(id).get();

        if (dish == null){
            throw new DishNotExistException("Такого блюда не существует");
        }
        dish.setName(changedDish.getName());
        dish.setIngredients(changedDish.getIngredients());
        dish.setWeight(changedDish.getWeight());
        return dishRepository.save(dish);
    }

    public Dish findDishByName (String name) throws DishNotExistException {
        if (dishRepository.findByName(name) == null){
            throw new DishNotExistException("Данного блюда нет в меню.");
        }
        return dishRepository.findByName(name);
    }

    public String delete(Long id) throws DishNotExistException {
        if (dishRepository.findById(id).get() == null ){
            throw new DishNotExistException("Данного блюда нет в меню.");
        }
        dishRepository.deleteById(id);
        return "Блюдо было успешно удалено из меню.";
    }

}
