package com.rakib.rabitmq.publisher;

import com.rakib.rabitmq.dto.Order;
import com.rakib.rabitmq.dto.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderPublisher {

    @Value("${rabbitmq.exchange}")
    private String exchange;
    @Value("${rabbitmq.routing-key}")
    private String routingQueue;
    private final RabbitTemplate template;

    @PostMapping("/{restaurantName}")
    public String bookOrder(@RequestBody Order order, @PathVariable String restaurantName) {
        order.setOrderId(UUID.randomUUID().toString());
        //restaurant service
        //payment service
        OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "order placed succesfully in "
                + restaurantName);
        template.convertAndSend(exchange, routingQueue, orderStatus);
        return "Success !!";
    }
}
