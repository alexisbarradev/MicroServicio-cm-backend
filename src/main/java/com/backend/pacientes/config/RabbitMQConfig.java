package com.backend.pacientes.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // 📌 Valores desde application.properties
    @Value("${app.rabbitmq.exchange}")
    private String exchange;

    @Value("${app.rabbitmq.queue}")
    private String queue;

    @Value("${app.rabbitmq.routingkey}")
    private String routingKey;

    // ✅ Crear Exchange
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(exchange);
    }

    // ✅ Crear Queue
    @Bean
    public Queue pacienteQueue() {
        return new Queue(queue, true); // true = durable
    }

    // ✅ Binding entre Exchange y Queue usando Routing Key
    @Bean
    public Binding binding(Queue pacienteQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(pacienteQueue).to(directExchange).with(routingKey);
    }
}
