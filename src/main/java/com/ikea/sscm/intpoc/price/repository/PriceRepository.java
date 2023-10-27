package com.ikea.sscm.intpoc.price.repository;

import com.ikea.sscm.intpoc.price.model.Price;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends MongoRepository<Price, String> {}
