package com.example.RestApiService.Entities.Dish;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dishes")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "ingredients", nullable = false)
    private String ingredients;

    @Column(name = "weight", nullable = false)
    private double weight;

    @JsonManagedReference // для исправления ошибки связанной с зацикливанием вывода цены блюда
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "dish")
    private List<DishPrice> dishPriceList;

    public Dish() {
    }
    // Добавления новой цены при изменении блюда
//    public void addDishPrice(DishPrice dishPrice){
//        dishPriceList.add(dishPrice);
//        dishPrice.setDish(this);
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

//    public DishPrice getDishPriceLast(){
//        return dishPriceList.get(dishPriceList.size()-1);
//    }

    public void setDishPriceList(List<DishPrice> dishPriceList) {//, DishPrice dishPrice
        this.dishPriceList = dishPriceList;
//        dishPriceList.add(dishPrice);
    }
}
