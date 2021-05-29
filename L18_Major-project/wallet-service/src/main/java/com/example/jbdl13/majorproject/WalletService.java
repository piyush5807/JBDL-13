package com.example.jbdl13.majorproject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    private static final String TOPIC_USER_CREATE = "user_create";

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    WalletRepository walletRepository;

    @KafkaListener(topics = {TOPIC_USER_CREATE}, groupId = "wallet-group")
    public void createWallet(String message) throws JsonProcessingException {
        JSONObject jsonObject = objectMapper.readValue(message, JSONObject.class);

        walletRepository.save(
                Wallet.builder()
                        .userId((String) jsonObject.get("userId"))
                        .balance((Integer) jsonObject.get("balance"))
                        .build()
        );
    }
}
