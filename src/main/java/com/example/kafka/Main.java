package com.example.kafka;

import com.datastax.oss.driver.api.core.CqlSession;
import com.example.kafka.util.CassandraKeyspaceInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main{

    public static void main(String[] args) {

        try (CqlSession cqlSession = CqlSession.builder().build()) {
            CassandraKeyspaceInitializer.createKeyspace(cqlSession);
        }
        SpringApplication.run(Main.class, args);
    }
}
