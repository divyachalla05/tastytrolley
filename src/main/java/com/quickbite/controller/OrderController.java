package com.quickbite.controller;

import com.quickbite.model.FoodOrder;
import com.quickbite.model.OrderRequest;
import com.quickbite.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public FoodOrder placeOrder(@RequestBody OrderRequest request) {
        return orderService.placeOrder(request);
    }

    @GetMapping("/{id}")
    public FoodOrder getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }
}
