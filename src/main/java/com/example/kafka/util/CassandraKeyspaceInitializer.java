package com.example.kafka.util;

import com.datastax.oss.driver.api.core.CqlSession;

public class CassandraKeyspaceInitializer {

    public static void createKeyspace(CqlSession cqlSession) {
        String keyspaceName = "test";
        String replicationStrategy = "SimpleStrategy";
        int replicationFactor = 1;

        // Create keyspace if it doesn't exist
        cqlSession.execute(String.format(
                "CREATE KEYSPACE IF NOT EXISTS %s WITH replication = {'class': '%s', 'replication_factor': %d}",
                keyspaceName, replicationStrategy, replicationFactor));
    }
}
