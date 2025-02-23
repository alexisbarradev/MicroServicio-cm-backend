package com.backend.pacientes.config;

import com.backend.pacientes.dto.VitalSignsDTO;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public ProducerFactory<String, VitalSignsDTO> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        //configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka-kafka-1-1:9092,kafka-kafka-2-1:9092,kafka-kafka-3-1:9092");
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092,localhost:39092,localhost:49092");

        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, VitalSignsDTO> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}

