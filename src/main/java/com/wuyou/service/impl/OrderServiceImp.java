package com.wuyou.service.impl;

import com.wuyou.mapper.OrderMapper;
import com.wuyou.model.Order;
import com.wuyou.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void addOrder(Order order) {
        orderMapper.addOrder(order);
    }
}
