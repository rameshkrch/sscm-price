package com.ikea.sscm.intpoc.price.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

  @Value("${kafka.bootstrapServer}")
  private String bootstrapServer;

  @Value("${kafka.input.topic.name}")
  private String priceTopicName;

  @Bean
  public KafkaAdmin kafkaAdmin() {
    Map<String, Object> configs = new HashMap<>();
    configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
    return new KafkaAdmin(configs);
  }

  @Bean
  public NewTopic priceTopic() {
    return new NewTopic(priceTopicName, 1, (short) 1);
  }
}
