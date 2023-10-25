package com.ikea.sscm.intpoc.price;

import com.ikea.sscm.intpoc.price.messaging.MessageListener;
import com.ikea.sscm.intpoc.price.messaging.MessageProducer;
import com.ikea.sscm.intpoc.price.model.Price;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class PriceApplication {

  public static void main(String[] args) throws InterruptedException {

    ConfigurableApplicationContext context = SpringApplication.run(PriceApplication.class, args);

    MessageProducer producer = context.getBean(MessageProducer.class);
    MessageListener listener = context.getBean(MessageListener.class);

    producer.sendPriceMessage(
        new Price(
            2,
            "5001-SUP-1",
            "2023-04-24",
            "2023-04-26",
            "AVL",
            "Avaialable from 24 April - 26 April, 2023"));
    listener.priceLatch.await(10, TimeUnit.SECONDS);
  }

  @Bean
  public MessageProducer messageProducer() {
    return new MessageProducer();
  }

  @Bean
  public MessageListener messageListener() {
    return new MessageListener();
  }
}
