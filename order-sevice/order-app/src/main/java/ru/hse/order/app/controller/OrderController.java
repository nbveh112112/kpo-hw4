package ru.hse.order.app.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.hse.order.api.OrderApi;
import ru.hse.order.app.mapper.OrderMapper;
import ru.hse.order.app.service.OrderService;
import ru.hse.order.api.dto.Order;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController implements OrderApi {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @Override
    @PostMapping
    public Order orderCreate(@RequestBody Order request) {
        request = orderMapper.appDto2ApiDto(orderService.createOrder(orderMapper.apiDto2AppDto(request), null));
        return request;
    }

    @Override
    @PutMapping
    public void orderUpdate(@RequestBody Order request) {
        orderService.updateOrder(orderMapper.apiDto2AppDto(request));
    }

    @Override
    @GetMapping("/{id}")
    public Order orderGet(@PathVariable UUID id) {
        return orderMapper.appDto2ApiDto(orderService.getOrderById(id));
    }

    @Override
    @DeleteMapping
    public void orderDelete(UUID request) {
        orderService.deleteOrder(request);
    }

    @Override
    @GetMapping("/user/{id}")
    public List<Order> getOrdersByUserId(@PathVariable UUID id) {
        var list = orderService.getOrdersByUserId(id);
        return list.stream()
                .map(orderMapper::appDto2ApiDto)
                .toList();
    }
}
