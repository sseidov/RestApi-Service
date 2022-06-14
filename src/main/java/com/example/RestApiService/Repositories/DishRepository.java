package com.example.RestApiService.Repositories;

import com.example.RestApiService.Entities.Dish.Dish;
import org.springframework.data.repository.CrudRepository;

public interface DishRepository extends CrudRepository<Dish, Long> {
    Dish findByName(String name);
}
