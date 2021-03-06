package com.codurance;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

public class Transaction {


  private final String date;
  private final int amount;

  public Transaction(String date, int amount) {
    this.date = date;
    this.amount = amount;
  }

  @Override
  public boolean equals(Object o) {
    return reflectionEquals(this, o);
  }

  @Override
  public int hashCode() {
    return reflectionHashCode(this);
  }

  public String date() {
    return date;
  }

  public int amount() {
    return amount;
  }
}
