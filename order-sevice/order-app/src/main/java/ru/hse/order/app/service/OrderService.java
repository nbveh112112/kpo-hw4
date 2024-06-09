package ru.hse.order.app.service;

import ru.hse.order.app.dto.Order;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public interface OrderService {
    Order createOrder(Order order, Timestamp time);
    void deleteOrder(UUID id);
    void updateOrderStatus(UUID id, int status);
    Order getOrderById(UUID id);

    List<Order> getOrdersByUserId(UUID id);

    void updateOrder(Order order);

}
