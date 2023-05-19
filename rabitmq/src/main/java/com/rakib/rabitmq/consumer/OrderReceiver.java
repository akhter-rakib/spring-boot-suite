package com.rakib.rabitmq.consumer;

import com.rakib.rabitmq.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderReceiver {

    @RabbitListener(queues = "private_queue")
    public void consumerMessageFromQueue(OrderStatus orderStatus) {
        System.out.println("Message recieved from queue : " + orderStatus);
    }
}