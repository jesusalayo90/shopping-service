package com.mservices.shopping.service;

import com.mservices.shopping.entity.Order;
import com.mservices.shopping.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order saveOrder(Order order) {
        if (order != null) {
            order.setCreatedAt(new Date());
            order.setDeleted(Boolean.FALSE);
        }
        return orderRepository.save(order);
    }

    public Order getOrder(String serial) {
        Order order = orderRepository.findBySerialAndDeleted(serial, Boolean.FALSE).orElse(null);
        return order;
    }
}
