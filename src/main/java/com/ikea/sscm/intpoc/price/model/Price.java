package com.ikea.sscm.intpoc.price.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@Document(collection = "price")
public class Price implements Serializable {

  private int eventId;
  private String supplierId;
  private String startDate;
  private String endDate;
  private String availability;
  private String description;

  public Price() {}

  @Override
  public String toString() {
    return eventId
        + ", "
        + supplierId
        + ","
        + startDate
        + ","
        + endDate
        + ","
        + availability
        + ","
        + description;
  }
}
