package com.quickbite.controller;

import com.quickbite.model.FoodItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    private final List<FoodItem> menu = List.of(
            new FoodItem(1L, "Veg Burger", "Burgers", 129.00, true),
            new FoodItem(2L, "Paneer Wrap", "Wraps", 159.00, true),
            new FoodItem(3L, "Margherita Pizza", "Pizza", 249.00, true),
            new FoodItem(4L, "French Fries", "Sides", 89.00, true),
            new FoodItem(5L, "Chocolate Brownie", "Desserts", 99.00, false)
    );

    @GetMapping
    public List<FoodItem> getMenu() {
        return menu;
    }
}
