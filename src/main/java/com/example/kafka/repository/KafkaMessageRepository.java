package com.example.kafka.repository;

import com.example.kafka.model.KafkaMessage;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KafkaMessageRepository extends CassandraRepository<KafkaMessage, String> {
}
