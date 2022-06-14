package com.example.RestApiService.Controllers;

import com.example.RestApiService.Entities.Dish.Dish;
import com.example.RestApiService.Exceptions.DishAlreadyExistException;
import com.example.RestApiService.Exceptions.DishNotExistException;
import com.example.RestApiService.Services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dish")
public class DishController {
    @Autowired
    DishService dishService;

    @PostMapping("/add")
    public ResponseEntity addNewDish(@RequestBody Dish dish){
        try {
            dishService.addNewDish(dish);
            return ResponseEntity.ok("Блюдо было успешно добавлено в меню");
        } catch (DishAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка добавления нового блюда в меню.");
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity updateDish(@PathVariable Long id,
                                     @RequestBody Dish dish){
        try {
            dishService.updateDish(id,dish);
            return ResponseEntity.ok("Блюдо было успешно изменено");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка изменения блюда в меню.");
        }
    }

    @GetMapping("/get")
    public ResponseEntity getDishByName(@RequestParam String name) {
        try {
            return ResponseEntity.ok(dishService.findDishByName(name));
        }
        catch (DishNotExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка вывода информации о блюде из меню");
        }
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity deleteDish(@PathVariable Long id){
        try {
            return ResponseEntity.ok(dishService.delete(id));
        }
        catch (DishNotExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка удаления блюда из меню");
        }
    }

}
