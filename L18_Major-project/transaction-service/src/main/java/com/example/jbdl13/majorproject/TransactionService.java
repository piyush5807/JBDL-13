package com.example.jbdl13.majorproject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    RestTemplate restTemplate;

    private static final String TOPIC_TRANSACTION_INITIATE = "transaction_initiate";
    private static final String TOPIC_WALLET_UPDATE = "wallet_update";
    private static final String TOPIC_TRANSACTION_COMPLETED = "transaction_complete";

    public void createTransaction(TransactionRequest transactionRequest) throws JsonProcessingException {

        Transaction transaction =
            Transaction.builder()
                .fromUser(transactionRequest.getFromUserId())
                .toUser(transactionRequest.getToUserId())
                .amount(transactionRequest.getAmount())
                .transactionId(UUID.randomUUID().toString())
                .purpose(transactionRequest.getPurpose())
                .transactionStatus(TransactionStatus.PENDING)
                .build();

        transactionRepository.save(transaction);

        JSONObject walletUpdateRequest = new JSONObject();
        walletUpdateRequest.put("to", transactionRequest.getToUserId());
        walletUpdateRequest.put("from", transactionRequest.getFromUserId());
        walletUpdateRequest.put("amount", transactionRequest.getAmount());
        walletUpdateRequest.put("transactionId", transaction.getTransactionId());

        kafkaTemplate.send(TOPIC_TRANSACTION_INITIATE,
                transaction.getTransactionId(),
                objectMapper.writeValueAsString(walletUpdateRequest));
    }

    @KafkaListener(topics = {TOPIC_WALLET_UPDATE}, groupId = "transaction-group")
    public void updateTransaction(String message) throws JsonProcessingException {

        JSONObject transactionUpdateRequest = objectMapper.readValue(message, JSONObject.class);

        String transactionId = (String) transactionUpdateRequest.get("transactionId");
        String status = (String) transactionUpdateRequest.get("status");

        // 1. Update the transaction status

        transactionRepository.updateTransactionStatus(transactionId,
                TransactionStatus.valueOf(status));

        // 2. Notify the user

        Transaction transaction = transactionRepository.findByTransactionId(transactionId);
        String fromUserId = transaction.getFromUser();
        String toUserId = transaction.getToUser();

        URI url = URI.create("http://localhost:8000/user/" + fromUserId);

        JSONObject fromUser = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(new HttpHeaders()), JSONObject.class).getBody();

        String fromUserEmail = (String) fromUser.get("email");

        JSONObject emailRequest = new JSONObject();
        emailRequest.put("email", fromUserEmail);
        emailRequest.put("message", "Hey " + fromUserId + ", your transaction of amount " + transaction.getAmount() +
                " with id " + transactionId + "has been " + status);

        kafkaTemplate.send(TOPIC_TRANSACTION_COMPLETED, objectMapper.writeValueAsString(emailRequest));

        if(TransactionStatus.valueOf(status).equals(TransactionStatus.SUCCESS)){
            url = URI.create("http://localhost:8000/user/" + toUserId);
            JSONObject toUser = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(new HttpHeaders()), JSONObject.class).getBody();
            String toUserEmail = (String) toUser.get("email");

            emailRequest = new JSONObject();
            emailRequest.put("email", toUserEmail);
            emailRequest.put("message", "Hey " + toUserId + ", you got " + transaction.getAmount() +
                    " amount from " + fromUserId);

            kafkaTemplate.send(TOPIC_TRANSACTION_COMPLETED, objectMapper.writeValueAsString(emailRequest));

        }
    }
}
