package com.shop.seedlings.service;

import com.shop.seedlings.domain.entity.Order;

import java.util.List;

public interface OrderService {
    void saveOrder(Order order);

    Order getOrderById(int orderId);
}
