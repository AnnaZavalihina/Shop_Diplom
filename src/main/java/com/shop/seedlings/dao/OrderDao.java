package com.shop.seedlings.dao;

import com.shop.seedlings.domain.entity.Order;

import java.util.List;

public interface OrderDao {
    List<Order> getAllOrders();
    List<Order> getAllMadeOrders(String made);
    void saveOrder(Order order);
    Order getOrderById(int orderId);
}
