package com.shop.seedlings.service;

import com.shop.seedlings.dao.OrderDao;
import com.shop.seedlings.domain.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    @Transactional
    public void saveOrder(Order order) {
        orderDao.saveOrder(order);
    }

    @Override
    @Transactional
    public Order getOrderById(int orderId) {
        return orderDao.getOrderById(orderId);
    }
}
