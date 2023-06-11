package com.rakib.rabitmq.publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class OrderPublisher {
    private final RabbitTemplate template;

    @PostMapping("/check-rabbitmq-service")
    public String bookOrders(@RequestParam("exchangeName") String exchangeName,
                             @RequestParam("routingKey") String routingKey,
                             @RequestParam("messageData") String messageData) {
        template.convertAndSend(exchangeName, routingKey, messageData);
        return "Success !!";
    }
}
