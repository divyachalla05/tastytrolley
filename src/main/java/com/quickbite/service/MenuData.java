package com.quickbite.service;

import com.quickbite.model.FoodItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MenuData {

    private final List<FoodItem> menu = List.of(
            new FoodItem(1L, "Veg Burger", "Burgers", 129.00, true),
            new FoodItem(2L, "Paneer Wrap", "Wraps", 159.00, true),
            new FoodItem(3L, "Margherita Pizza", "Pizza", 249.00, true),
            new FoodItem(4L, "French Fries", "Sides", 89.00, true),
            new FoodItem(5L, "Chocolate Brownie", "Desserts", 99.00, false)
    );

    public List<FoodItem> getMenu() {
        return menu;
    }

    public FoodItem findById(Long id) {
        return menu.stream()
                .filter(item -> item.id().equals(id))
                .findFirst()
                .orElse(null);
    }
}
