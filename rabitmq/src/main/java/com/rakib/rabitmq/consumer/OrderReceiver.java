package com.rakib.rabitmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderReceiver {

    @RabbitListener(queues = "q.jp_translation_queue")
    public void consumerMessageFromQueue(String message) {
        log.info("Message recieved from queue_jp : " + message);
    }

    @RabbitListener(queues = "q.en_translation_queue")
    public void consumeAnotherQueue(String message) {
        log.info("Message received from queue_en: " + message);
    }
}