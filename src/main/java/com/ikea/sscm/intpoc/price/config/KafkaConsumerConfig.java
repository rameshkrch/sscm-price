package com.ikea.sscm.intpoc.price.config;

import com.ikea.sscm.intpoc.price.model.Price;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

  @Value("${kafka.bootstrapServer}")
  private String bootstrapServer;

  @Value("${kafka.cg.price}")
  private String cgPrice;

  public ConsumerFactory<String, Price> priceConsumerFactory() {
    Map<String, Object> props = new HashMap<>();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
    props.put(ConsumerConfig.GROUP_ID_CONFIG, cgPrice);
    return new DefaultKafkaConsumerFactory<>(
        props, new StringDeserializer(), new JsonDeserializer<>(Price.class));
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, Price>
      priceKafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, Price> factory =
        new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(priceConsumerFactory());
    return factory;
  }
}
