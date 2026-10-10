package com.quickbite.service;

import com.quickbite.model.FoodItem;
import com.quickbite.model.FoodOrder;
import com.quickbite.model.OrderRequest;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class OrderService {

    private final MenuData menuData;
    private final Map<Long, FoodOrder> orders = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(1000);

    public OrderService(MenuData menuData) {
        this.menuData = menuData;
    }

    public FoodOrder placeOrder(OrderRequest request) {
        if (request == null || request.foodItemId() == null) {
            throw new IllegalArgumentException("Food item ID is required");
        }

        if (request.quantity() < 1 || request.quantity() > 20) {
            throw new IllegalArgumentException("Quantity must be between 1 and 20");
        }

        FoodItem item = menuData.findById(request.foodItemId());

        if (item == null) {
            throw new IllegalArgumentException("Food item not found");
        }

        if (!item.available()) {
            throw new IllegalArgumentException("Food item is unavailable");
        }

        long id = sequence.incrementAndGet();

        FoodOrder order = new FoodOrder(
                id,
                item.name(),
                request.quantity(),
                item.price() * request.quantity(),
                "PLACED",
                Instant.now()
        );

        orders.put(id, order);
        return order;
    }

    public FoodOrder getOrder(Long id) {
        FoodOrder order = orders.get(id);

        if (order == null) {
            throw new IllegalArgumentException("Order not found");
        }

        return order;
    }
}
