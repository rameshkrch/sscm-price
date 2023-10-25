package com.ikea.sscm.intpoc.price.messaging;

import com.ikea.sscm.intpoc.price.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

public class MessageProducer {

  @Autowired private KafkaTemplate<String, Price> priceKafkaTemplate;

  @Value("${kafka.input.topic.name}")
  private String priceTopicName;

  public MessageProducer() {}

  public void sendPriceMessage(Price price) {
    priceKafkaTemplate.send(priceTopicName, price);
  }
}
