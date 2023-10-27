package com.ikea.sscm.intpoc.price.service;

import com.ikea.sscm.intpoc.price.model.Price;

import java.util.List;

public interface PriceService {

  void sendPrice(Price price) throws InterruptedException;

    List<Price> getPrices();
}
