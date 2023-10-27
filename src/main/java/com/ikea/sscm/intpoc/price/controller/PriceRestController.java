package com.ikea.sscm.intpoc.price.controller;

import com.ikea.sscm.intpoc.price.model.Price;
import com.ikea.sscm.intpoc.price.service.PriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/price", produces = "application/json")
@Slf4j
public class PriceRestController {

  @Autowired PriceService priceService;

  @PostMapping("/publish")
  public void sendPrice(@RequestBody Price price) throws InterruptedException {
    priceService.sendPrice(price);
  }

  @GetMapping("/subscribe")
  public List<Price> getPrices() {
    return priceService.getPrices();
  }

}
