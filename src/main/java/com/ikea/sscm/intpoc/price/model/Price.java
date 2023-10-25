package com.ikea.sscm.intpoc.price.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.kafka.common.protocol.types.Field;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class Price {

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
