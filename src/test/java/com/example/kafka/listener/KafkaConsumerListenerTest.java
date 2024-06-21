package com.example.kafka.listener;

import com.example.kafka.model.KafkaMessage;
import com.example.kafka.repository.KafkaMessageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

import static org.mockito.Mockito.*;

@SpringBootTest
@EmbeddedKafka(partitions = 1, topics = { "users" }, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
public class KafkaConsumerListenerTest {

    @Mock
    private KafkaMessageRepository kafkaMessageRepository;

    @InjectMocks
    private KafkaConsumerListener kafkaConsumerListener;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testConsume() {
        String testMessage = "Test message";

        // Simulate consuming a message
        kafkaConsumerListener.listen(testMessage);

        // Verify that the repository's save method was called with the expected message
        verify(kafkaMessageRepository, times(1)).save(any(KafkaMessage.class));
    }
}
