package com.example.jbdl13.demokafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "jbdl-13-console-topic";

    private static Logger logger = LoggerFactory.getLogger(MessageController.class);

    @PostMapping("/message")
    public void produceMsg(@RequestParam("msg") String msg, @RequestParam("key") String key){

        kafkaTemplate.send(TOPIC, key, msg);
        logger.info("Produced msg {} on this topic {}", msg, TOPIC);
    }

    @KafkaListener(topics = {TOPIC}, groupId = "jbl13-test2")
    public void consumeMsg(String message){
        logger.info("Consumed the message {}", message);
    }

    @KafkaListener(topics = {TOPIC})
    public void consumeMsg2(String msg){
        logger.info("Consumed the msg {}", msg);
    }


    //  org.apache.kafka.clients.consumer.KafkaConsumer@3f5dc01e - p1
    // org.apache.kafka.clients.consumer.KafkaConsumer@3f5dc01e - p0
    // org.apache.kafka.clients.consumer.KafkaConsumer@1c3975f1 - p2
}
