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

  @Value("${kafka.bootstrap.servers}")
  private String bootstrapServer;

  @Value("${kafka.sasl.mechanism}")
  private String saslMechanism;

  @Value("${kafka.sasl.jaas.config}")
  private String saslJaasConfig;

  @Value("${kafka.security.protocol}")
  private String securityProtocol;

  @Value("${kafka.consumer.group.name}")
  private String cgPrice;

  public ConsumerFactory<String, Price> priceConsumerFactory() {
    Map<String, Object> configProps = new HashMap<>();
    configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
    configProps.put("sasl.jaas.config", saslJaasConfig);
    configProps.put("security.protocol", securityProtocol);
    configProps.put("sasl.mechanism", saslMechanism);
    configProps.put(ConsumerConfig.GROUP_ID_CONFIG, cgPrice);
    return new DefaultKafkaConsumerFactory<>(
        configProps, new StringDeserializer(), new JsonDeserializer<>(Price.class));
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
