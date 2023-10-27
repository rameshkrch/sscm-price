package com.ikea.sscm.intpoc.price;

import com.ikea.sscm.intpoc.price.messaging.MessageListener;
import com.ikea.sscm.intpoc.price.messaging.MessageProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class PriceApplication {

  public static void main(String[] args) throws InterruptedException {

    SpringApplication.run(PriceApplication.class, args);
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
