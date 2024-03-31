package com.example.demo;

import com.example.demo.kafka.KafkaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FooService {

    @Autowired
    KafkaService kafkaService;

    public String fetchFoo() {
        return "foo";
    }

    public void sendSpam(String message) {
        log.info("At the service layer :: received request to send message to Kafka topic: {}", message);
        kafkaService.publishSpamMessage(message);
    }
}
