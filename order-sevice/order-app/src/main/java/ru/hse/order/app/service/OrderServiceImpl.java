package ru.hse.order.app.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hse.order.app.exception.NotFoundById;
import ru.hse.order.app.dto.Order;
import ru.hse.order.app.handler.OrderHandler;
import ru.hse.order.app.mapper.OrderMapper;
import ru.hse.order.data.api.repository.OrderRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
    @Service
    @AllArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final OrderHandler orderHandler;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    @Override
    public Order createOrder(Order order, Timestamp time) {
        order.setStatus(1);
        order = orderMapper.dataModel2AppDto(
                orderRepository.save(orderMapper.appDto2DataModel(order)));
        orderHandler.handleOrder(order.getId());
        return order;
    }

    @Override
    public void deleteOrder(UUID id) {
        if (!orderRepository.existsById(id)) {
            throw new NotFoundById(id);
        }
        orderRepository.deleteById(id);
    }

    @Override
    public void updateOrderStatus(UUID id, int status) {
        if (!orderRepository.existsById(id)) {
            throw new NotFoundById(id);
        }
        orderRepository.updateStatusById(id, status);
    }

    @Override
    public Order getOrderById(UUID id) {
        if(!orderRepository.existsById(id)) {
            throw new NotFoundById(id);
        }
        return orderMapper.dataModel2AppDto(orderRepository.findById(id));
    }

    @Override
    public List<Order> getOrdersByUserId(UUID id) {
        var list = orderRepository.findByUserId(id);
        return list.stream()
                .map(orderMapper::dataModel2AppDto)
                .toList();
    }

    @Override
    public void updateOrder(Order order) {
        if (!orderRepository.existsById(order.getId())) {
            throw new NotFoundById(order.getId());
        }
        orderRepository.updateById(orderMapper.appDto2DataModel(order));
    }

}
