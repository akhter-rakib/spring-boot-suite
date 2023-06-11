package com.rakib.rabitmq.config;


import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
/*@Configuration is the source of been definition. It tells spring
 * container that it is a configuration class and scan it for bean definition */
public class RabbitMQTopicConfig {

    @Value("${rabbitmq.queue_en}")
    private String enTranslationQueue;

    @Value("${rabbitmq.queue_jp}")
    private String jpTranslationQueue;
    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routing-key_en}")
    private String enRoutingKey;

    @Value("${rabbitmq.routing-key_jp}")
    private String jpRoutingKey;

    private final CachingConnectionFactory cachingConnectionFactory;

    @Bean
    public Queue enQueue() {
        return new Queue(enTranslationQueue, false);
    }

    @Bean
    public Queue jpQueue() {
        return new Queue(jpTranslationQueue, false);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(exchange);
    }

    @Bean
    public Binding enBinding(Queue enQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(enQueue).to(topicExchange).with(enRoutingKey);
    }

    @Bean
    public Binding jpBinding(Queue jpQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(jpQueue).to(topicExchange).with(jpRoutingKey);
    }

    /*The Jackson2JsonMessageConverter is a message converter provided by the Spring AMQP framework that
     allows you to convert between Java objects and JSON messages when sending or receiving messages with RabbitMQ.*/
    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(Jackson2JsonMessageConverter converter) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(cachingConnectionFactory);
        rabbitTemplate.setMessageConverter(converter);
        return rabbitTemplate;
    }
}