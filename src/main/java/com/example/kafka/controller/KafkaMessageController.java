package com.example.kafka.controller;

import com.example.kafka.model.KafkaMessage;
import com.example.kafka.repository.KafkaMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class KafkaMessageController {

    @Autowired
    private KafkaMessageRepository kafkaMessageRepository;

    @GetMapping
    public Iterable<KafkaMessage> getMessages() {
        return kafkaMessageRepository.findAll();
    }
}
