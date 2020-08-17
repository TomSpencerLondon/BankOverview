package com.codurance;

import static java.util.Collections.EMPTY_LIST;
import static org.mockito.Mockito.verify;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StatementPrinterShould {

  private static final List<Transaction> NO_TRANSACTIONS = EMPTY_LIST;
  @Mock
  Console console;
  private StatementPrinter statementPrinter;

  @BeforeEach
  void setUp() {
    statementPrinter = new StatementPrinter(console);
  }

  @Test
  void always_print_the_header() {
    statementPrinter.print(NO_TRANSACTIONS);

    verify(console).printLine("DATE | AMOUNT | BALANCE");
  }
}
