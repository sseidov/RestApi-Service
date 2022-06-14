package com.example.RestApiService.Controllers;

import com.example.RestApiService.Entities.Dish.DishPrice;
import com.example.RestApiService.Exceptions.DishNotExistException;
import com.example.RestApiService.Services.DishPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dish/price")
public class DishPriceController {

    @Autowired
    DishPriceService dishPriceService;

    @PostMapping("/add")
    public ResponseEntity addNewDishPrice(@RequestBody DishPrice dishPrice,
                                          @RequestParam Long dishId){
        try {
            dishPriceService.addNewPriceToDish(dishPrice, dishId);
            return ResponseEntity.ok("Цена блюда была успешно изменена");
        } catch (DishNotExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка добавления новой цены блюда.");
        }
    }


}
