package com.example.soundx.service;




import com.example.soundx.model.Order;

import java.util.List;

public interface OrderService {
    public Order saveOrder(Order order);
    public List<Order> getAllOrders();

    public Order findMatchForOrder(Order order);

    public void deleteOrder(int id);
}
