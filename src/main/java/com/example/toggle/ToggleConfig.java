package com.example.toggle;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.togglz.core.repository.StateRepository;
import org.togglz.mongodb.MongoStateRepository;

@Configuration
public class ToggleConfig  {
  @Value("${spring.togglz.collection-name}")
  private String togglzTableName;

  @Value("${spring.data.mongodb.database}")
  private String mongoDbName;

  private final MongoClient mongoClient;

  public ToggleConfig(MongoClient mongoClient) {
    this.mongoClient = mongoClient;
  }

  @Bean
  public StateRepository getStateRepository() {
    return MongoStateRepository
        .newBuilder(mongoClient, mongoDbName)
        .collection(togglzTableName)
        .build();
  }
}
