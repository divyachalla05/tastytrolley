package com.quickbite.model;

import java.time.Instant;

public record FoodOrder(
        Long orderId,
        String itemName,
        int quantity,
        double totalPrice,
        String status,
        Instant createdAt
) {}
