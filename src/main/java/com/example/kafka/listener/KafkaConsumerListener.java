package com.example.kafka.listener;

import com.example.kafka.model.KafkaMessage;
import com.example.kafka.repository.KafkaMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerListener {

    @Autowired
    private KafkaMessageRepository kafkaMessageRepository;

    @KafkaListener(topics = "users", groupId = "group_id")
    public void listen(String message) {
        System.out.println(message);
        KafkaMessage kafkaMessage = new KafkaMessage();
        kafkaMessage.setId(java.util.UUID.randomUUID().toString());
        kafkaMessage.setMessage(message);

        kafkaMessageRepository.save(kafkaMessage);
    }
}
