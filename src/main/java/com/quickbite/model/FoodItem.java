package com.quickbite.model;

public record FoodItem(
        Long id,
        String name,
        String category,
        double price,
        boolean available
) {}
