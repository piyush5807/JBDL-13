package com.example.jbdl13.majorproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.web.client.RestTemplate;

import java.util.Properties;

@Configuration
public class TransactionConfig {

    @Bean
    Properties getKafkaProps(){
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        return properties;
    }


    @Bean
    ProducerFactory<String, String> getProducerFactory(){
        return new DefaultKafkaProducerFactory(getKafkaProps());
    }

    @Bean
    ConsumerFactory<String, String> getConsumerFactory(){
        return new DefaultKafkaConsumerFactory(getKafkaProps());
    }

    @Bean
    ConcurrentKafkaListenerContainerFactory<String, String> concurrentKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory();
        kafkaListenerContainerFactory.setConsumerFactory(getConsumerFactory());
        return kafkaListenerContainerFactory;
    }

    @Bean
    KafkaTemplate<String, String> getKafkaTemplate(){
        return new KafkaTemplate(getProducerFactory());
    }

    @Bean
    ObjectMapper getObjectMapper(){
        return new ObjectMapper();
    }

    @Bean
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
