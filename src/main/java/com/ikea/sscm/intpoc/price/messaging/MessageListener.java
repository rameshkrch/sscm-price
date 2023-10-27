package com.ikea.sscm.intpoc.price.messaging;

import com.ikea.sscm.intpoc.price.model.Price;
import com.ikea.sscm.intpoc.price.repository.PriceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

@Slf4j
public class MessageListener {

  @Autowired
  PriceRepository priceRepository;

  public final CountDownLatch priceLatch = new CountDownLatch(1);

  @KafkaListener(
      topics = "${kafka.input.topic.name}",
      containerFactory = "priceKafkaListenerContainerFactory",
      groupId = "${kafka.consumer.group.name}")
  public void priceListener(Price price) {
    log.info("Price message received -> " + price);
    priceRepository.save(price);
    this.priceLatch.countDown();
  }
}
