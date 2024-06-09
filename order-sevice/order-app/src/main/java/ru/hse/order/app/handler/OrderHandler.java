package ru.hse.order.app.handler;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.hse.order.data.api.model.Order;
import ru.hse.order.data.api.repository.OrderRepository;

import java.util.Random;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderHandler {
    private final OrderRepository orderRepository;
    @Async
    public void handleOrder(UUID order_id) {
        Random random = new Random();
        System.out.println(order_id);
        Order order = orderRepository.findById(order_id);
        if (order != null) {
            if (order.getStatus() == 1) {
                try {
                    Thread.sleep(random.nextInt(3000) + 1000);
                } catch (Exception ignored) {}
                //random number 2 or 3
                orderRepository.updateStatusById(order_id, random.nextInt(2) + 1);
            }
        }
    }

}
