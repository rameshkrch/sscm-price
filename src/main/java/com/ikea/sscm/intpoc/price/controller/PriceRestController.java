package com.ikea.sscm.intpoc.price.controller;

import com.ikea.sscm.intpoc.price.messaging.MessageProducer;
import com.ikea.sscm.intpoc.price.model.Price;
import com.ikea.sscm.intpoc.price.service.PriceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/", produces = "application/json")
@Slf4j
public class PriceRestController {

  @Autowired PriceService priceService;

  @PostMapping("/sendprice")
  public void sendPrice(@RequestBody Price price) throws InterruptedException {
    priceService.sendPrice(price);
  }

}
