package com.shop.seedlings.dao;

import com.shop.seedlings.domain.entity.Order;

public interface OrderDao {
    void saveOrder(Order order);

    Order getOrderById(int orderId);
}
