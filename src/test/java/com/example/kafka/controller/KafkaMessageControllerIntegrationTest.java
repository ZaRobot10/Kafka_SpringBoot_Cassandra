package com.example.kafka.controller;

import com.example.kafka.model.KafkaMessage;
import com.example.kafka.repository.KafkaMessageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(KafkaMessageController.class)
public class KafkaMessageControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private KafkaMessageRepository kafkaMessageRepository;

    private KafkaMessage message1;
    private KafkaMessage message2;

    @BeforeEach
    public void setUp() {
        message1 = new KafkaMessage();
        message1.setId("1");
        message1.setMessage("Message 1");

        message2 = new KafkaMessage();
        message2.setId("2");
        message2.setMessage("Message 2");
    }

    @Test
    public void testGetMessages() throws Exception {
        given(kafkaMessageRepository.findAll()).willReturn(Arrays.asList(message1, message2));

        mockMvc.perform(get("/messages"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].message").value("Message 1"))
                .andExpect(jsonPath("$[1].id").value("2"))
                .andExpect(jsonPath("$[1].message").value("Message 2"));
    }
}
