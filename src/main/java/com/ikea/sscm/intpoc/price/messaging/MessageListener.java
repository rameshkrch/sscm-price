package com.ikea.sscm.intpoc.price.messaging;

import com.ikea.sscm.intpoc.price.model.Price;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

@Slf4j
public class MessageListener {

  public final CountDownLatch priceLatch = new CountDownLatch(1);

  @KafkaListener(
      topics = "${kafka.input.topic.name}",
      containerFactory = "priceKafkaListenerContainerFactory")
  public void priceListener(Price price) {
    log.info("Received price message: " + price);
    this.priceLatch.countDown();
  }
}
