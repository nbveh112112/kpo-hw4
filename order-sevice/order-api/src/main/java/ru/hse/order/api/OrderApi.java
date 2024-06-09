package ru.hse.order.api;

import ru.hse.order.api.dto.Order;

import java.util.List;
import java.util.UUID;

public interface OrderApi {
    Order orderCreate(Order request);
    void orderUpdate(Order request);
    Order orderGet(UUID request);
    void orderDelete(UUID request);

    List<Order> getOrdersByUserId(UUID id);
}
