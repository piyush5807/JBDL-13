package com.example.jbdl13.majorproject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.jws.Oneway;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    ObjectMapper objectMapper;

    private static String REDIS_USER_KEY_PREFIX = "user::";

    private static final String USER_CREATE_TOPIC = "user_create";

    @Value("${user.account.create.default.balance}")
    int defaultBalance;

    public void createUser(User user) throws JsonProcessingException {

        // 1. Create an entry in db and redis

        userRepository.save(user);
        redisTemplate.opsForValue().set(REDIS_USER_KEY_PREFIX + user.getUserId(), user);

        // 2. Create a wallet of this user

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userId", user.getUserId());
        jsonObject.put("balance", defaultBalance);

        kafkaTemplate.send(USER_CREATE_TOPIC, user.getUserId(), objectMapper.writeValueAsString(jsonObject));
    }

    public User getUser(String userId){

        // 1. Search in the cache, if found then return otherwise get form db and return

        User user = (User)redisTemplate.opsForValue().get(REDIS_USER_KEY_PREFIX + userId);

        if(user == null){
            user = userRepository.findByUserId(userId);
            if(user != null){
                redisTemplate.opsForValue().set(REDIS_USER_KEY_PREFIX + user.getUserId(), user);
            }
        }

        return user;
    }

}
