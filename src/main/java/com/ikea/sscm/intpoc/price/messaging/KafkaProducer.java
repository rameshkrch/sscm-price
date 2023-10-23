package com.ikea.sscm.intpoc.price.messaging;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class KafkaProducer {

  private final KafkaTemplate<String, Object> kafkaTemplate;

  public void sendMessage(Object message) {
    kafkaTemplate
        .send("price-input-topic", message)
        .whenComplete(
            (result, ex) -> {
              if (ex == null) {
                log.info("Message sent to topic: {}", message);
              } else {
                log.error("Failed to send message", ex);
              }
            });
  }
}
