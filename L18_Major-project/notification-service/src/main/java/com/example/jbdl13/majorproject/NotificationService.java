package com.example.jbdl13.majorproject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private static final String TOPIC_TRANSACTION_COMPLETE = "transaction_complete";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SimpleMailMessage simpleMailMessage;

    @Autowired
    private JavaMailSender javaMailSender;

    @KafkaListener(topics = {TOPIC_TRANSACTION_COMPLETE}, groupId = "email-group")
    public void sendMail(String message) throws JsonProcessingException {
        JSONObject emailRequest = objectMapper.readValue(message, JSONObject.class);

        String email = (String) emailRequest.get("email");
        String text = (String) emailRequest.get("message");

        simpleMailMessage.setText(text);
        simpleMailMessage.setFrom("gfg.ewallet@gmail.com");
        simpleMailMessage.setSubject("Transaction Notification");
        simpleMailMessage.setTo(email);

        javaMailSender.send(simpleMailMessage);
    }
}
