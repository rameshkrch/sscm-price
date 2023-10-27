package com.ikea.sscm.intpoc.price.config;

import com.ikea.sscm.intpoc.price.model.Price;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

  @Value("${kafka.bootstrapServer}")
  private String bootstrapServer;

  @Value("${kafka.sasl.mechanism}")
  private String saslMechanism;

  @Value("${kafka.sasl.jaas.config}")
  private String saslJaasConfig;

  @Value("${kafka.security.protocol}")
  private String securityProtocol;


  @Bean
  public ProducerFactory<String, Price> priceProducerFactory() {
    Map<String, Object> configProps = new HashMap<>();
    configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
    configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
    /*
    configProps.put("sasl.jaas.config", saslJaasConfig);
    configProps.put("security.protocol", securityProtocol);
    configProps.put("sasl.mechanism", saslMechanism);
    */
    return new DefaultKafkaProducerFactory<>(configProps);
  }

  @Bean
  public KafkaTemplate<String, Price> priceKafkaTemplate() {
    return new KafkaTemplate<>(priceProducerFactory());
  }
}
