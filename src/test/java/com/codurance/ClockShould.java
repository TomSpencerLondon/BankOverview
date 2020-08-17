package com.codurance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClockShould {

  private Clock clock;

  @BeforeEach
  void setUp() {
    clock = new TestableClock();
  }

  @Test
  void return_todays_date_in_dd_MM_yyyy_format() {
    String date = clock.todayAsString();
    assertEquals("24/04/2015", date);
  }

  private class TestableClock extends Clock {

    @Override
    protected LocalDate today() {
      return LocalDate.of(2015, 4, 24);
    }
  }
}
