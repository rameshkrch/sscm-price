package com.ikea.sscm.intpoc.price.service;

import com.ikea.sscm.intpoc.price.messaging.MessageProducer;
import com.ikea.sscm.intpoc.price.model.Price;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PriceServiceImpl implements PriceService {

  @Autowired MessageProducer producer;

  @Override
  public void sendPrice(Price price) throws InterruptedException {
    producer.sendPriceMessage(price);
  }
}
