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
