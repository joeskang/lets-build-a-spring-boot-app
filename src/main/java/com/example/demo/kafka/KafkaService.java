package com.example.demo.kafka;

import com.example.demo.rdb.SpamEntity;
import com.example.demo.rdb.SpamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaService {

    @Autowired
    SpamRepository spamRepository;

    private final KafkaTemplate<String, String> kafkaTemplate;
    public KafkaService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void publishSpamMessage(String message) {
        log.info("Received request to publish message to Kafka topic: {}", message);
        try {
            kafkaTemplate.send("spam-topic", message);
            log.info("Message successfully sent to Kafka topic.");
        } catch (KafkaException e) {
            log.error("Unable to publish message to Kafka topic!");
        }
    }

    @KafkaListener(topics = "spam-topic")
    public void processMessage(String content) {
        log.info("Received message from Kafka topic: {}", content);
        log.info("Will attempt to store the message \"{}\" to database", content);

        try {
            SpamEntity spamEntity = new SpamEntity();
            spamEntity.setMessage(content);
            spamRepository.save(spamEntity);
            log.info("Successfully stored the message in the database");
        } catch (Exception e) {
            log.error("Error caught when attempting to store Spam in database.");
            throw e;
        }

    }

}
