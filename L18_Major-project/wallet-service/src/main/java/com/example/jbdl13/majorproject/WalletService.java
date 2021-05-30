package com.example.jbdl13.majorproject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    private static final String TOPIC_USER_CREATE = "user_create";
    private static final String TOPIC_TRANSACTION_INITIATE = "transaction_initiate";
    private static final String TOPIC_WALLET_UPDATE = "wallet_update";

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    WalletRepository walletRepository;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

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

    @KafkaListener(topics = {TOPIC_TRANSACTION_INITIATE}, groupId = "wallet-group")
    public void updateWallets(String message) throws JsonProcessingException {
        JSONObject walletUpdateRequest = objectMapper.readValue(message, JSONObject.class);

        String toUserId = (String) walletUpdateRequest.get("to");
        String fromUserId = (String) walletUpdateRequest.get("from");
        int amount = (Integer) walletUpdateRequest.get("amount");
        String transactionId = (String) walletUpdateRequest.get("transactionId");

        Wallet from_wallet = walletRepository.findByUserId(fromUserId);

        JSONObject transactionUpdateRequest = new JSONObject();
        transactionUpdateRequest.put("transactionId", transactionId);

        if(from_wallet == null || from_wallet.getBalance() < amount){
            transactionUpdateRequest.put("status", "FAILED");
        } else {

            //        walletRepository.decrementWallet(fromUserId, amount);
            //        walletRepository.incrementWallet(toUserId, amount);

            walletRepository.updateWallet(fromUserId, 0 - amount);
            walletRepository.updateWallet(toUserId, amount);
            transactionUpdateRequest.put("status", "SUCCESS");
        }

        kafkaTemplate.send(TOPIC_WALLET_UPDATE,
                transactionId,
                objectMapper.writeValueAsString(transactionUpdateRequest));
    }
}
