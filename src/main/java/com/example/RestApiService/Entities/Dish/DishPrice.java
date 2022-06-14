package com.example.RestApiService.Entities.Dish;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "dishes_price")
public class DishPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_from", nullable = false)
    private Date date_from;

    @Column(name = "price", nullable = false)
    private Double price;

    @JsonBackReference // для исправления ошибки связанной с зацикливанием вывода цены блюда
    @ManyToOne
    @JoinColumn(name = "dishes_id")
    private Dish dish;

    public DishPrice() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }
}
