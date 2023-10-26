package com.ikea.sscm.intpoc.price.service;

import com.ikea.sscm.intpoc.price.model.Price;

public interface PriceService {

  void sendPrice(Price price) throws InterruptedException;
}
