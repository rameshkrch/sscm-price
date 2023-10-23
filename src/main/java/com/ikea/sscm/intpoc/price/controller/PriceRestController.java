package com.ikea.sscm.intpoc.price.controller;

import com.ikea.sscm.intpoc.price.messaging.KafkaProducer;
import com.ikea.sscm.intpoc.price.model.Price;
import com.ikea.sscm.intpoc.price.service.PriceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/price", produces = "application/json")
public class PriceRestController {

  private final KafkaProducer kafkaProducer;

  @Autowired private PriceService priceService;

  @GetMapping("/getprice")
  public List<Price> getPrice() {
    return priceService.getPrices();
  }

  @PostMapping("/sendprice")
  public void addMessage(@RequestBody Price message) {
    kafkaProducer.sendMessage(message);
  }
}
